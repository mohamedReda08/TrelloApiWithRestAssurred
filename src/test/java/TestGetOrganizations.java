import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetOrganizations {
    @Test
    public void getOrganizations(){
        var projectVariables = new ProjectVariables();
        String pathParameter = "/members/" + ProjectVariables.getUserID() +"/organizations";

        System.out.println(pathParameter);
        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath(pathParameter)
                .queryParam("key", Credentials.APIKey)
                .queryParam("token", Credentials.token);

        Response response = request.get();

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

    }
}
