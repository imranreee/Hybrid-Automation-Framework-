package api;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest {
    @Test
    public void getData(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Imran");
        jsonObject.put("job", "SDET");

        given().header("Content-Type","application/json")
                .body(jsonObject.toString())
                .when().post(baseURI).then().assertThat()
                .statusCode(201);
    }
}
