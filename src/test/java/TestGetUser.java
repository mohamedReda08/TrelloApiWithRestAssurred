import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGetUser {


    @Test
    public void getUser(){
        ProjectVariables projectVariables = new ProjectVariables();
         RestAssured.baseURI =Credentials.baseURI;
         RequestSpecification request = RestAssured.given()
                 .basePath("/members/me")
                 .queryParam("key",Credentials.APIKey )
                 .queryParam("token",Credentials.token);

         Response getUserResponse = request.get();
        Assert.assertEquals(getUserResponse.statusCode(), 200);
         JsonPath path = getUserResponse.jsonPath();
         String userId = path.getString("id");
         projectVariables.setUserID(userId);

        System.out.println("User ID is" + projectVariables.getUserID());

    }



}