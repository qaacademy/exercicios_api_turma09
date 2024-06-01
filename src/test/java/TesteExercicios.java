import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TesteExercicios {

    @Test
    public void exercicio04_TesteParOuImpar() {

        String url = "http://localhost:8080/exercicios/parOuImpar";
        String msgResponseBody = "O numero 2 é par";

        RestAssured.given()
                .queryParam("numero", 2)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.equalTo(msgResponseBody));
    }

    @Test
    public void exercicio05_TesteParOuImpar() {

        String pathParamSalario = "3000";
        String url = "http://localhost:8080/exercicios/calculaSalario/" + pathParamSalario;

        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Salario liquido = 2050.65"));
    }

    @Test
    public void exercicio06_TesteCpf() {

        String pathParamSalario = "3000";
        String url = "http://localhost:8080/exercicios/validarCpf";

        String cpf = "76734533042";

        RestAssured.given()
                .log().all()
                .queryParam("cpf", cpf)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.equalTo("CPF Valido"));
    }

}
