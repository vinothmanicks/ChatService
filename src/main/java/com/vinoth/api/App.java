package com.vinoth.api;

import com.vinoth.api.historymanagement.ChatService;
import com.vinoth.api.historymanagement.FileHistoryManagement;
import com.vinoth.api.historymanagement.HistoryManagement.InMemoryChatService;
import com.vinoth.api.model.Calculation;
import com.vinoth.api.model.Calculation.Operation;
import com.vinoth.api.historymanagement.HistoryManagement;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class App {

    public static void main(String[] args) {

        HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();
        ChatService history = new FileHistoryManagement.FileMemoryChatService("global");

        get("/", (request, response) -> {
            Float userInput1 = request.queryMap("input1").floatValue();
            Float userInput2 = request.queryMap("input2").floatValue();

            Map<String, Object> map = new HashMap<>();
            map.put("input1", userInput1);
            map.put("input2", userInput2);
            map.put("operations", Operation.values());

            if (userInput1 != null && userInput2 != null) {
                String op = request.queryMap("op").value();
                Operation operation = Operation.valueOf(op);
                Calculation calculation = new Calculation(userInput1, userInput2);
                float result = calculation.performOperation(operation);
                map.put("operationType", op);
                map.put("operationResult", result);
            }

            return templateEngine.render(new ModelAndView(map, "index.hbs"));
        });

        get("/chat", (request, response) -> {

            Map<String, Object> map = new HashMap<>();

            String input = request.queryMap("input").value();
            String op = request.queryMap("op").value();

            if ("Clear History".equals(op)) {
                history.clearHistory();
            }
            else if ("Submit".equals(op)) {
                if (input != null && !input.isEmpty()) {
                    history.appendMessage(null, input);
                }
            }

            map.put("history", history.getCompleteHistory());

            return templateEngine.render(new ModelAndView(map, "chat.hbs"));
        });
    }

}
