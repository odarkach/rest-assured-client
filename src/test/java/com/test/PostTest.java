package com.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.test.TestUtils.getPeople;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostTest {

    private RequestSpecification spec;

    @BeforeSuite
    //используем общие настройки для всех тестов
    public void setUp() {
        String baseURL = "https://jsonplaceholder.typicode.com/";

        spec = new RequestSpecBuilder()
                .setBaseUri(baseURL)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Test
    public void testPostWithObjectMapperTest() {
        Post expectedPost = new Post()
                .setUserId(1)
                .setId(1)
                .setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")
                .setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");

        Post actualPost = given().spec(spec).
                expect().
                statusCode(200).
                when().
                get("posts/1").as(Post.class);
        assertEquals(actualPost, expectedPost);
    }

    @Test
    public void testHomeTaskCheckCountOfIdEqualsOne() {

        Posts post = given().spec(spec).get("/posts").body().as(Posts.class);
        assertEquals(personsExpected, Posts.getPost());

        Post actualPost = given().spec(spec).
                expect().
                statusCode(200).
                when().
                get("posts").as(Post.class);
        assertEquals(actualPost, expectedPost);
    }

}
