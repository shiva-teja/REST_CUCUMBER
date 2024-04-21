import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {
    @Test
    public void testAPI() {
        given()
            .baseUri("https://api.example.com")
            .basePath("/users")
        .when()
            .get("/123")
        .then()
            .assertThat().statusCode(200)
            .assertThat().header("Content-Type", containsString("application/json"))
            .assertThat().body("id", equalTo(123))
            .assertThat().body("name", equalTo("John Doe"));
    }
}
