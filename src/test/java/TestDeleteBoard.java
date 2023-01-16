import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteBoard{
    @Test
    public void deleteBoard(){
        ProjectVariables projectVariables = new ProjectVariables();
        String pathParameter = "/boards/"+ projectVariables.getBoardID();

        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath(pathParameter)
                .queryParams("key", Credentials.APIKey, "token", Credentials.token);

        Response response = request.delete();

        Assert.assertEquals(response.statusCode(), 200);

    }
}
