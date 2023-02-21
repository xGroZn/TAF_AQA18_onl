package tests.api;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import baseEntities.BaseApiGsonTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestRailMilestoneTest extends BaseApiGsonTest {
    ProjectAdapter projectAdapter = new ProjectAdapter();
    MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
    Project expectedProject;
    Milestone expectedMilestone;
    int projectID;
    int milestoneID;

    @Test
    public void addMilestone() {

        expectedProject = new Project();
        expectedProject.setName("Project_by_Budnik");
        expectedProject.setAnnouncement("New project by Budnik");
        expectedProject.setType(1);
        expectedProject.setShowAnnouncement(true);

        expectedMilestone = new Milestone();
        expectedMilestone.setName("Milestone_by_Budnik");
        expectedMilestone.setDescription("Just description");

        projectID = projectAdapter.add(expectedProject).getBody().jsonPath().getInt("id");
        milestoneID = milestoneAdapter.add(expectedMilestone, projectID).getBody().jsonPath().getInt("id");

        assertThat(milestoneAdapter.add(expectedMilestone, projectID).getBody().jsonPath().getString("name"), equalTo(expectedMilestone.getName()));
    }

    @Test (dependsOnMethods = "addMilestone")
    public void getMilestone() {
        assertThat(milestoneAdapter.get(milestoneID).getBody().jsonPath().getString("name"), equalTo(expectedMilestone.getName()));
    }

    @Test (dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        expectedMilestone.setDescription("Changes in description");
        assertThat(milestoneAdapter.update(expectedMilestone, milestoneID).getBody().jsonPath().getString("description"), equalTo(expectedMilestone.getDescription()));

    }

    @Test (dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        milestoneAdapter.delete(expectedMilestone, milestoneID);
    }
}