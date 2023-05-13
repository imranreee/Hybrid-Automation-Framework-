package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest {
    @Test
    public void getData(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        given().queryParam("page","2").header("","").when().get().then().log().all();
    }
}
