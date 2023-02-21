package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Cases;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CaseAdapter extends BaseAdapter{

    public Cases add(Cases cases, int sectionID) {
        return given()
                .pathParams("section_id", sectionID)
                .body(cases, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Cases.class, ObjectMapperType.GSON);
    }

    public int getCaseID(Cases cases, int sectionID) {
        int caseID;
        Response response = given()
                .pathParams("section_id", sectionID)
                .body(cases, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        return caseID = response.getBody().jsonPath().getInt("id");
    }


    public Cases get(int caseID) {
        return given()
                .pathParams("case_id", caseID)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Cases.class, ObjectMapperType.GSON);
    }

    public Cases update(Cases cases, int caseID) {
        return given()
                .pathParams("case_id", caseID)
                .body(cases, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Cases.class, ObjectMapperType.GSON);
    }

    public Cases delete(Cases cases, int caseID) {
        return given()
                .pathParams("case_id", caseID)
                .body(cases, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Cases.class, ObjectMapperType.GSON);
    }
}
