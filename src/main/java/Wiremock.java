import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class Wiremock {
    static WireMockServer wireMockServer = new WireMockServer(); //No-args constructor will start on port 8080, no HTTPS

    public static void getBasona() {
        wireMockServer.start();
        stubFor(get(urlEqualTo("/basona"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Hello world - BASONA!")));
    }

    public static void validaBasona() {
        given()
                .log().all()
                .when()
                .log().all()
                .get("/basona")
                .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", is("application/json"))
                .body(is(notNullValue()))
                .body(is("Hello world - BASONA!"));
        wireMockServer.stop();
    }

    public static void getRelatos() {
        wireMockServer.start();
        stubFor(get(urlEqualTo("/relatos"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(400)
                        .withBody("Hello world - RELATOS!")));
    }

    public static void validaRelatos() {
        given()
                .log().all()
                .when()
                .log().all()
                .get("/relatos")
                .then()
                .log().all()
                .statusCode(400)
                .header("Content-Type", is("application/json"))
                .body(is(notNullValue()))
                .body(is("Hello world - RELATOS!"));
        wireMockServer.stop();
    }
}
