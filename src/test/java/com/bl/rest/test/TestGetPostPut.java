package com.bl.rest.test;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.reporters.XMLConstants;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGetPostPut {

    @Test
    public void test_1_Get() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael", "Lindsay")).
                and().log().all();

    }

    @Test
    public void test_2_Post() {
        // Map<String,Object> map = new HashMap<String, Object>();
        // map.put("name","Dhanashree");
        // map.put("job","QA");

        //System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("name", "Dhanashree");
        request.put("job", "QA");
        System.out.println(request);

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201);
    }

    @Test
    public static void test_03_Put(){

        JSONObject request1 = new JSONObject();
        request1.put("name", "Dhanashree");
        request1.put("job", "QA");
        System.out.println(request1);

        given().
                body(request1.toJSONString()).
                when().
                post("https://reqres.in/api/users/2").
                then().
                statusCode(201);

    }
}
