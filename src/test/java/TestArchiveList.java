import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestArchiveList {
@Test

    public void archiveList(){
    ProjectVariables projectVariables = new ProjectVariables();
    String pathParameter = "/lists/"+projectVariables.getListID()+"/closed" ;

    RestAssured.baseURI = Credentials.baseURI;
    RequestSpecification request = RestAssured.given()
            .basePath(pathParameter)
            .queryParams("key", Credentials.APIKey, "token", Credentials.token, "value", true);
    request.header("Content-Type", "application/json");

    Response response = request.put();
response.prettyPrint();
    JsonPath path = response.jsonPath();
    boolean isArchived = path.getBoolean("closed");
    int statusCode = response.getStatusCode();

//    Assertion
    Assert.assertEquals(statusCode, 200);
    Assert.assertTrue(isArchived);

}
}

