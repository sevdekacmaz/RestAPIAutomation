package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class UserTests {

    @Test
    public void getUserInfo() {
       // RestAssured.get("https://petstore.swagger.io/v2/user/sevde");
        RestAssured.given().get("https://petstore.swagger.io/v2/user/sevde").then().assertThat().statusCode(200);

    }
    @Test
    public void createUserInfo() {
        String payLoad = "{\n" +
                "  \"id\": 14,\n" +
                "  \"username\": \"can\",\n" +
                "  \"firstName\": \"Can\",\n" +
                "  \"lastName\": \"Şeker\",\n" +
                "  \"email\": \"can@gmail.com\",\n" +
                "  \"password\": \"000000000\",\n" +
                "  \"phone\": \"5555555555\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().assertThat().statusCode(200);

    }
}
