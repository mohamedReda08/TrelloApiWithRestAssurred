import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateList {

@Test
    public void createList(){
    var projectVariables = new ProjectVariables();
    RestAssured.baseURI = Credentials.baseURI;
    RequestSpecification request = RestAssured.given()
            .basePath("/lists")
            .queryParams("name","To Do", "idBoard", ProjectVariables.getBoardID(),
                    "key", Credentials.APIKey, "token", Credentials.token);

    request.header("Content-Type", "application/json");

    Response response = request.post();

    JsonPath path = response.jsonPath();

    String listId = path.getString("id");
    ProjectVariables.setListID(listId);
    System.out.println("list ID is" + projectVariables.getListID());

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(path.getString("idBoard") , ProjectVariables.getBoardID());



    }

}
