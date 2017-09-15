package com.test;

import com.jayway.awaitility.Duration;
import com.jayway.awaitility.core.ConditionFactory;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.awaitility.Awaitility.await;
import static io.restassured.RestAssured.given;

public class AwaitTest extends TestBase {

//await(), atMost() etc returns immutable ConditionFactory. -> configure once behavior for polling and waiting and reuse it
    public static final ConditionFactory WAIT = await()
            .atMost(new Duration(15, TimeUnit.SECONDS))
            .pollInterval(Duration.ONE_SECOND)
            .pollDelay(Duration.ONE_SECOND);


    @Test(timeOut = 60000)
    public void waitAndPoll2() {
        WAIT.until(() -> {
            given().spec(spec)
                    .when()
                    .get("single-user")
                    .then()
                    .statusCode(HttpStatus.SC_OK);
        });
    }

}
