import com.google.gson.Gson;
import spark.QueryParamsMap;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;

public class HelloWorld {
    public static void main(String[] args) {

        Route helloHandler = (request, response) -> {
            QueryParamsMap queryMap = request.queryMap();
            int a = queryMap.get("a").integerValue();
            int b = queryMap.get("b").integerValue();
            int c = queryMap.get("c").integerValue();
            return String.format("Sum = %d", a + b + c);
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

}
