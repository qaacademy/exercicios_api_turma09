import io.restassured.RestAssured;
import org.apache.http.Header;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestePrimeiraApi {

    @Test
    public void exercicio01_TesteComSucessoPrimeiraApi() {

        String url = "http://localhost:8080/api/primeiraApi";

        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Retorno da api com sucesso!!!"));
    }

    @Test
    public void exercicio02_TesteQueryParamPrimeiraApi() {

        String url = "http://localhost:8080/api/primeiraApiV1";
        String textoQueryParam = "QA Academy";

        RestAssured.given()
                .queryParam("palavra",textoQueryParam)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(textoQueryParam));
    }


}
