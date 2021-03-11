package steps;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.HTTP;
import org.testng.Assert;
import pages.ApiMethods;
import support.ApisCollection;
import support.Config;
import support.PageObjectManager;

import java.io.IOException;
import java.util.Locale;


public class ApiSteps {
    private ApiMethods apiMethods;
    private ApisCollection apisCollection;
    private String apiURL = "";
    private int responseStatus;

    public ApiSteps(PageObjectManager pageObjectManager) {
        apiMethods = pageObjectManager.getApiMethods();
    }

    @Given("We have the {string} url")
    public void weHaveTheApi(String apiMethod) {
        apiMethod = apiMethod.toLowerCase();
        apiURL = ApisCollection.getApiUrl().get(apiMethod);
    }

    @When("A record is created {string}")
    public void aRecordIsCreated(String status) throws Exception {
        status = status.toLowerCase();
        if (status.contains("unsuccess")) {
            responseStatus = apiMethods.postMethodCall(apiURL, Config.getJson("failure"));
        } else if (status.contains("success")) {
            responseStatus = apiMethods.postMethodCall(apiURL, Config.getJson("successPOST"));
        } else {
            Assert.fail();
        }
    }

    @Then("The response {int} is shown")
    public void theResponseIsShown(int statusCode) {
        Assert.assertEquals(responseStatus, statusCode, "Response is not matching: " + responseStatus);
    }

    @When("A {int} is updated {string}")
    public void aRecordIsUpdated(int id, String status) throws Exception {
        if (status.contains("unsuccess")) {
            responseStatus = apiMethods.putMethodCall(apiURL + id, Config.getJson("failure"));
        } else if (status.contains("success")) {
            responseStatus = apiMethods.putMethodCall(apiURL + id, Config.getJson("update"));
        } else {
            Assert.fail();
        }
    }

    @Then("We can access the details of the {int} successfully")
    public void weCanAccessTheDetailsSuccessfully(int id) throws IOException {
        responseStatus = apiMethods.getMethodCall(apiURL + id);
        Assert.assertEquals(responseStatus, 200);
    }

    @Then("We can delete the {int} successfully")
    public void weCanDeleteTheRecordSuccessfully(int id) throws IOException {
        responseStatus = apiMethods.deleteMethodCall(apiURL + id);
        Assert.assertEquals(responseStatus, 200);
    }
}
