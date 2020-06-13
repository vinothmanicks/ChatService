import com.google.gson.Gson;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;
import java.util.Set;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        Route helloHandler = (request, response) -> {
            QueryParamsMap queryMap = request.queryMap();
            int a = queryMap.get("a").integerValue();
            int b = queryMap.get("b").integerValue();
            int c = queryMap.get("c").integerValue();
            return String.format("Sum = %d", a + b+ c);
        };
        get("/hello", helloHandler);

        post("/post", (request, response) -> {
            String body = request.body();
            //Map<String, String> params = request.params();
            PostHelloWorld hello = new Gson().fromJson(request.body(), PostHelloWorld.class);
            return hello.hello;
        });
    }

    class PostHelloWorld {
        public String hello;
    }
//    static class HelloHandler implements Route{
//
//        @Override
//        public Object handle(Request request, Response response) throws Exception {
//            return "HelloWorld";
//        }
//    }
}
