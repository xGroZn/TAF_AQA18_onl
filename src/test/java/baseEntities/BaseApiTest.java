package baseEntities;

import configuration.ReadProperties;
import dbTables.MilestonesTable;
import dbTables.ProjectsTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.MilestoneBuilder;
import models.ProjectBuilder;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected DataBaseService dbService;

    @BeforeTest
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        dbService = new DataBaseService();

        ProjectsTable projectsTable = new ProjectsTable(dbService);

        projectsTable.dropTable();
        projectsTable.createTable();

        projectsTable.addProject(ProjectBuilder.builder()
                .name("Project_num_1")
                .announcement("My first own project")
                .type(1)
                .showAnnouncement(true)
                .build());

        projectsTable.addProject(ProjectBuilder.builder()
                .name("Project_num_2")
                .announcement("My second own project")
                .type(1)
                .showAnnouncement(true)
                .build());

        MilestonesTable milestonesTable = new MilestonesTable(dbService);

        milestonesTable.dropTable();
        milestonesTable.createTable();

        milestonesTable.addMilestone(MilestoneBuilder.builder()
                .name("Milestone_num_1")
                .description("Just description")
                .build());

        milestonesTable.addMilestone(MilestoneBuilder.builder()
                .name("Milestone_num_2")
                .description("Not just a description")
                .build());
    }

    @AfterTest
    public void tearDown() {
        dbService.closeConnection();
    }
}
