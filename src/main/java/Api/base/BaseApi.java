package Api.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.PropertyReader.getBaseUrlApi;
import static utils.PropertyReader.getToken;

public class BaseApi {

    public Gson gson = new GsonBuilder().
            excludeFieldsWithoutExposeAnnotation().
            create();

    RequestSpecification requestSpecification;

    public BaseApi() {
        requestSpecification =
                given().
                        header("Token", getToken()).
                        header("Content-Type", "application/json").
                        log().all();
        }

    protected Response get(String uri, int statusCode) {
        return requestSpecification.
                when().
                        get(getBaseUrlApi() + uri).
                then().
                        log().all().
                        statusCode(statusCode).
                        extract().response();
    }

    protected Response post(String body, String uri, int statusCode) {
        return requestSpecification.
                        body(body).
                when().
                        post( getBaseUrlApi() + uri).
                then().
                        log().all().
                        statusCode(statusCode).
                        extract().response();
    }

    protected Response patch(String body, String uri, int statusCode) {
        return requestSpecification.
                        body(body).
                when().
                        patch(getBaseUrlApi() + uri).
                then().
                        log().all().
                        statusCode(statusCode).
                        extract().response();
    }

    protected Response delete(String uri, int statusCode) {
            return requestSpecification.
                when().
                        delete(getBaseUrlApi() + uri).
                then().
                        log().all().
                        statusCode(statusCode).
                        extract().response();
    }
}
