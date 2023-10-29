package user;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import baseURL.BaseUrl;

public class UserApiMethods {
    private User user;
    private static final String CREATE_USER = "/api/auth/register";
    private static final String DELETE_USER = "/api/auth/user";
    private static final String LOGIN_USER = "/api/auth/login";


    public UserApiMethods(User user){
        this.user = user;
    }


    public Response sendRequestCreate(){
        RestAssured.baseURI = BaseUrl.getBaseURL();
        return  given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(CREATE_USER);
    }


    public Response sendRequestDelete(User user) {
        RestAssured.baseURI = BaseUrl.getBaseURL();
          return given()
                .header("Authorization", user.getAccessToken())
                .delete(DELETE_USER);
    }

    public Response sendRequestLogin(User user){
        RestAssured.baseURI = BaseUrl.getBaseURL();
        String loginAndPasswordJson = "{\n" +
                "\"email\": " + "\""+ user.getEmail() + "\"" +",\n" +
                "\"password\": " + "\"" + user.getPassword() + "\"\n" +
                "}";

        Response  response = given()
                .header("Content-type", "application/json")
                .body(loginAndPasswordJson)
                .when()
                .post(LOGIN_USER);
        String fullAccessToken = response.path("accessToken");
        user.setAccessToken(fullAccessToken.substring(7));
        return response;
    }

    public boolean isUserExist(User user){
        RestAssured.baseURI = BaseUrl.getBaseURL();
        String loginAndPasswordJson = "{\n" +
                "\"email\": " + "\""+ user.getEmail() + "\"" +",\n" +
                "\"password\": " + "\"" + user.getPassword() + "\"\n" +
                "}";

        Response  response = given()
                .header("Content-type", "application/json")
                .body(loginAndPasswordJson)
                .when()
                .post(LOGIN_USER);

        return response.path("success").equals(true);
    }
}
