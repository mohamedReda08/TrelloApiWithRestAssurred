import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetBoards {
    @Test
    public void getBoards(){
        ProjectVariables projectVariables = new ProjectVariables();
        String pathParameter = "/organizations/"+ projectVariables.getOrganizationID()+"/boards";

        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath(pathParameter)
                .queryParam("key", Credentials.APIKey)
                .queryParam("token", Credentials.token);
        request.header("Content-Type", "application/json");

        System.out.println(pathParameter);
        Response response = request.get();

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

    }
}
