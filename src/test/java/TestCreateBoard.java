import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCreateBoard {
    @Test

    public void createBoard(){
        ProjectVariables projectVariables = new ProjectVariables();

        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath("/boards/").queryParam("name", "New Board")
                .queryParam("key", Credentials.APIKey)
                .queryParam("token", Credentials.token);
                request.header("Content-Type", "application/json");

        Response response = request.post();
        JsonPath path = response.jsonPath();
        projectVariables.setBoardID(path.getString("id"));
        System.out.println("Board Id is " + projectVariables.getBoardID());


        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }
}
