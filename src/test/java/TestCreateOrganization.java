import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Test
public class TestCreateOrganization {
    public void createOrganization(){
        ProjectVariables projectVariables = new ProjectVariables();

        RestAssured.baseURI = Credentials.baseURI;
        RequestSpecification request = RestAssured.given()
                .basePath("/organizations")
                .queryParam("displayName", "TrelloOrganization" )
                .queryParam("key", Credentials.APIKey)
                .queryParam("token", Credentials.token);
        request.header("Content-Type", "application/json");
       Response response= request.post();

       JsonPath path = response.jsonPath();
        String organizationID = path.getString("id");
        ProjectVariables.setOrganizationID(organizationID);

        System.out.println("organization ID is" + projectVariables.getOrganizationID());

    }
}
