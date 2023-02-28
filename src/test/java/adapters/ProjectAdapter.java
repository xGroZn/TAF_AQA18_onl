package adapters;

import dbTables.ProjectsTable;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.sql.ResultSet;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {
    ProjectsTable projectsTable;

    public Response add(Project project) {
        Response response = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return response;
    }
}