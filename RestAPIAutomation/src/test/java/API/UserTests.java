package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTests {

    @Test
    public void getUserInfo() {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id","24");
        bodyMap.put("username","Elif");
        bodyMap.put("firstName","Elif Can");
        bodyMap.put("lastName","Şeker");
        bodyMap.put("email","elif@gmail.com");
        bodyMap.put("password","000000000");
        bodyMap.put("phone","5555555555");
        bodyMap.put("userStatus","0");

        //Map<String, Object> bodyMap = new HashMap<>();
        //bodyMap.put("id","24");

        RestAssured.given().body(bodyMap).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().assertThat().statusCode(200);
        RestAssured.given().get("https://petstore.swagger.io/v2/user/Elif").then().assertThat().statusCode(200);

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

    @Test
    public void login() {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("username","can");
        queryParams.put("password","1234");
        RestAssured.given().queryParams(queryParams).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login").then().assertThat().statusCode(200);
    }

    @Test
    public void logOut() {

        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/logout").then().assertThat().statusCode(200);
    }

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setId(22);
        user.setUsername("Ali");
        user.setFirstName("Alican");
        user.setLastName("Şeker");
        user.setEmail("alican@gmail.com");
        user.setPassword("000000000");
        user.setPhone("5555555555");
        user.setUserStatus(0);
        String headersPayLoad = "{\n" +
                "  \"accept\": \"application/json\",\n" +
                "  \"Content-Type\": application/json\n" +
                "}";

        RestAssured.given().body(user).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/can").then().assertThat().statusCode(200);

    }

    @Test
    public void deleteUser() {

        RestAssured.given().contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/Ali").then().assertThat().statusCode(200);
    }

    @Test
    public void createWithList() {
        String payLoad = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"username\": \"ahmet\",\n" +
                "    \"firstName\": \"Ahmet\",\n" +
                "    \"lastName\": \"Öz\",\n" +
                "    \"email\": \"ahmet1@gmail.com\",\n" +
                "    \"password\": \"1234\",\n" +
                "    \"phone\": \"345\",\n" +
                "    \"userStatus\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"username\": \"mehmet\",\n" +
                "    \"firstName\": \"Mehmet\",\n" +
                "    \"lastName\": \"Masad\",\n" +
                "    \"email\": \"mehmet@gmail.com\",\n" +
                "    \"password\": \"234\",\n" +
                "    \"phone\": \"123213\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";

        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user/createWithList").then().assertThat().statusCode(200);

    }

    @Test
    public void createWithArray() {
        String payLoad = "[\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"username\": \"duygu\",\n" +
                "    \"firstName\": \"Duygu\",\n" +
                "    \"lastName\": \"Öz\",\n" +
                "    \"email\": \"duygu@gmail.com\",\n" +
                "    \"password\": \"3456\",\n" +
                "    \"phone\": \"123456\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        String headersPayLoad = "{\n" +
                "  \"accept\": \"application/json\",\n" +
                "  \"Content-Type\": application/json\n" +
                "}";

        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user/createWithArray").then().assertThat().statusCode(200);

    }

}
