package tests.api;

import adapters.CaseAdapter;
import baseEntities.BaseApiGsonTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Cases;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class TestRailCaseTest extends BaseApiGsonTest {
    CaseAdapter caseAdapter = new CaseAdapter();
    Cases expectedCase;
    int caseID;

    @Test
    public void addCase() {
        expectedCase = new Cases();
        expectedCase.setSectionID(1);
        expectedCase.setTitle("Case title");
        caseID = caseAdapter.getCaseID(expectedCase, expectedCase.getSectionID());
        Assert.assertEquals(caseAdapter.add(expectedCase, expectedCase.getSectionID()), expectedCase);
    }

    @Test (dependsOnMethods = "addCase")
    public void getCase() {
        Assert.assertEquals(caseAdapter.get(caseID), expectedCase);
    }

    @Test (dependsOnMethods = "addCase")
    public void updateCase() {
        expectedCase.setTitle("New title");
        Assert.assertEquals(caseAdapter.update(expectedCase, caseID), expectedCase);
    }

    @Test (dependsOnMethods = "updateCase")
    public void deleteCase() {
        caseAdapter.delete(expectedCase, caseID);
    }
}
