package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class MilestoneAdapter extends BaseAdapter{

    public Response add(Milestone milestone, int projectID) {
        Response response = given()
                .pathParams("project_id", projectID)
                .body(milestone)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return response;
    }

    public Response get(int milestoneID) {
        Response response = given()
                .pathParams("milestone_id", milestoneID)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return response;
    }

    public Response update(Milestone milestone, int milestoneID) {
        Response response = given()
                .pathParams("milestone_id", milestoneID)
                .body(milestone)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return response;
    }

    public Response delete(Milestone milestone, int milestoneID) {
        Response response = given()
                .pathParams("milestone_id", milestoneID)
                .body(milestone)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return response;
    }
}