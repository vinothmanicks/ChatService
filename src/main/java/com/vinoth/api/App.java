package com.vinoth.api;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.vinoth.api.model.Calculation;
import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.*;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();

        get("/", (request, response) -> {
            Integer userInput1 = request.queryMap("input1").integerValue();
            Integer userInput2 = request.queryMap("input2").integerValue();
            Map<String, Integer> map = new HashMap<>();
            map.put("input1", userInput1);
            map.put("input2", userInput2);
            if(userInput1!=null && userInput2!=null){
                int sum = userInput1 + userInput2;
                map.put("sum", sum);

            }

            String render = templateEngine.render(new ModelAndView(map, "index.hbs"));
            System.out.println(render);
            return render;
        });

        get("/add", (request, response) -> {
            return "placeholder";
        });

        post("/add", (request, response) -> {
            Calculation add = new Gson().fromJson(request.body(), Calculation.class);
            return add.add();
        });

        post("/subtract", (request, response) -> {
            Calculation sub = new Gson().fromJson(request.body(), Calculation.class);
            return sub.subtract();
        });

        post("/multiply", (request, response) -> {
            Calculation mul = new Gson().fromJson(request.body(), Calculation.class);
            return mul.multiply();
        });
    }

}
