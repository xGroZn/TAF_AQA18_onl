package tests.api;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import baseEntities.BaseApiGsonTest;
import models.Milestone;
import models.Project;
import org.testng.annotations.Test;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestRailMilestoneTest extends BaseApiGsonTest {
    ProjectAdapter projectAdapter = new ProjectAdapter();
    MilestoneAdapter milestoneAdapter = new MilestoneAdapter();
    Project expectedProject;
    Milestone expectedMilestone;
    int projectID;
    int milestoneID;
    DataBaseService dbService;


    @Test
    public void addMilestone() throws SQLException {
        dbService = new DataBaseService();

        String sqlProject = "SELECT * FROM public.projects;";
        String sqlMilestone = "SELECT * FROM public.milestones;";

        ResultSet rsProject = dbService.executeQuery(sqlProject);
        ResultSet rsMilestone = dbService.executeQuery(sqlMilestone);

        expectedProject = new Project();
        rsProject.next();
        expectedProject.setName(rsProject.getString("name"));
        rsProject.next();
        expectedProject.setAnnouncement(rsProject.getString("announcement"));
        expectedProject.setType(rsProject.getInt(4));
        expectedProject.setShowAnnouncement(rsProject.getBoolean(5));

        expectedMilestone = new Milestone();
        rsMilestone.next();
        expectedMilestone.setName(rsMilestone.getString("name"));
        rsMilestone.next();
        expectedMilestone.setDescription(rsMilestone.getString("description"));

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