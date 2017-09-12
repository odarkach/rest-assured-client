package com.test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.test.TestUtils.getCars;
import static com.test.TestUtils.getPeople;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

public class UserTest {

    private RequestSpecification spec;

    @BeforeSuite
    public void setUp() {
        String baseURL = "http://localhost:8080/service/";

        spec = new RequestSpecBuilder()
                .setBaseUri(baseURL)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Test
    public void testGetSingleUser() {
        given().spec(spec).
                expect().
                    statusCode(200).
                    body(
                            "email", equalTo("test@hascode.com"),
                            "firstName", equalTo("Tim"),
                            "lastName", equalTo("Testerman"),
                            "id", equalTo("1")
                    ).
                when().
                get("single-user");
    }

// this is the test that has been written before lombok plugin installation
//    @Test
//    public void testGetSingleUserWithObjectMapperTest() {
//        Person expectedPerson = new Person();
//        expectedPerson.setEmail("test@hascode.com");
//        expectedPerson.setFirstName("Tim");
//        expectedPerson.setLastName("Testerman");
//        expectedPerson.setId(1);
//
//        Person actualPerson = given().spec(spec).
//                expect().
//                    statusCode(200).
//                    when().
//                    get("single-user").as(Person.class);
//        assertEquals(actualPerson, expectedPerson);
//    }
//
//    @Test
//    public void testGetSingleUserWithObjectMapperTest() {
//        Person expectedPerson = new Person()
//            .setEmail("test@hascode.com")
//            .setFirstName("Tim")
//            .setLastName("Testerman")
//            .setId(1);
//
//        Person actualPerson = given().spec(spec).
//                expect().
//                    statusCode(200).
//                    when().
//                    get("single-user").as(Person.class);
//        assertEquals(actualPerson, expectedPerson);
//    }

    @Test
    public void testGetSingleUserWithObjectMapperTest1Json() {
        Person actualPerson = given().spec(spec).
                expect().
                statusCode(200).
                when().
                get("single-user").as(Person.class);
        assertEquals(actualPerson, TestUtils.getPeople().get(0));
    }

    @Test
    public void findListOfPersonsTestJson() {
        List<Person> personsExpected = getPeople();
        String json = given().spec(spec).get("persons/json").asString();
        JsonPath jp = new JsonPath (json);
        List<Person> personsActual = jp.getList("person", Person.class);
        assertEquals(personsExpected, personsActual);
    }

    @Test
    public void testGetSingleUserWithObjectMapperTestXml() {
        Person actualPerson = given().spec(spec).
                expect().
                statusCode(200).
                when().
                get("single-user/xml").as(Person.class);
        assertEquals(actualPerson, TestUtils.getPeople().get(0));
    }

    @Test
    public void findListOfPersonsTestXml() {
        List<Person> personsExpected = getPeople();

        People people = given().spec(spec).get("/persons/xml").body().as(People.class);
        assertEquals(personsExpected, people.getPerson());
    }

    @Test
    public void findListOfPersonsTestNewJson() {
        List<Person> personsExpected = getPeople();

        People people = given().spec(spec).get("persons/json").body().as(People.class);
        assertEquals(personsExpected, people.getPerson());
    }

    @Test
    public void carsTestXml() {
        List<Car> carsExpected = getCars();

        Cars cars = given().spec(spec).get("/cars/xml").body().as(Cars.class);
        assertEquals(carsExpected, cars.getCar());
    }

}
