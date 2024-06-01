package api_futebol;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TesteApiFutebol {

    @Test
    public void exercicioApi_Futebol() {

        String url = "https://api.api-futebol.com.br/v1/campeonatos";


        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer live_369a3475ba039356ce2add7815da12")
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Campeonato Brasileiro 2024"));
    }
}
