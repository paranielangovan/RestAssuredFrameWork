package com.Utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UtilityFile {

    public static RequestSpecification getRequestSpecification(){

        RequestSpecification  build = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();
        return build;
    }

    public static Object getJsonResponse(String response, String Key){
        JsonPath js = new JsonPath(response);
        Object o = js.getString(Key);
        return o;
    }
    public static String update_LocationBody(Object place_Id,Object address,Object key){
       String body = "{\\n\" +\n" +
               "                \"  \\\"place_id\\\":\""+place_Id+"\",\\n\" +\n" +
               "                \"  \\\"address\\\": \""+address+"\",\\n\" +\n" +
               "                \"  \\\"key\\\":\"+\""+key+"\"+\"\\n\" +\n" +
               "                \"}"
               ;
    return body;
    }
    public static String delete_LocationBody(Object place_Id){
        String body = "{\\n\" +\n" +
                "                \"  \\\"place_id\\\":\""+place_Id+"\",\\n\" +\n" +
                "                \"}"
                ;
        return body;
    }

}
