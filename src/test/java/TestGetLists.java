import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetLists {

    @Test
    public void getLists(){
        var projectVariables = new ProjectVariables();

        String pathParameter = "/boards/"+ProjectVariables.getBoardID()+ "/lists";
        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath(pathParameter)
                .queryParams("key", Credentials.APIKey, "token", Credentials.token);

        Response response = request.get();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
