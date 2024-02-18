package org.example;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class AppTest {
    @Test
    public void checkGetPostmanTest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then().log().body()
                .statusCode(200)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    public void checkPostPostmanTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Some raw text")
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("13"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void checkPutPostmanTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Some raw text")
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("13"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void checkDeletePostmanTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Some raw text")
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.content-length", equalTo("13"))
                .and().body("headers.x-amzn-trace-id", containsString("Root="))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", containsString("Apache-HttpClient"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }
}