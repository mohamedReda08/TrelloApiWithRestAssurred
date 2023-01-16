import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteOrganization {
    @Test
    public void deleteOrganization(){
        ProjectVariables projectVariables = new ProjectVariables();
        String pathParameter = "/organizations/"+ projectVariables.getOrganizationID();

        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath(pathParameter)
                .queryParams("key", Credentials.APIKey, "token", Credentials.token);

        Response response = request.delete();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
