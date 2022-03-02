package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.AuthenticationToken;
import model.Status;
import model.Ticket;
import model.Userpass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/** Абстрактный класс, содержащий общие для всех тестов методы */
public abstract class BaseTest {
    @BeforeClass
    public void prepare() {
        // todo: загрузить в системные переменные "base.uri" из "config.properties"
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }

        // todo: подготовить глобальные преднастройки для запросов


        RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(baseUri)
                    .addHeader("api_key", "Mdv31")
                    .setAccept(ContentType.JSON)
                    .setContentType(ContentType.JSON)
                    .build();

        RestAssured.filters(new ResponseLoggingFilter());
    }

    protected static Ticket buildNewTicket(Status status, int priority) {
        // todo: создать объект с тестовыми данными
        Ticket ticket = new Ticket();
        ticket.setPriority(priority);
        ticket.setStatus(status.getCode());
        return ticket;
    }

    protected Ticket createTicket(Ticket ticket) {
        // todo: отправить HTTP запрос для создания тикета
        AuthenticationToken authenticationToken=authenticate();

        //System.out.println(authenticationToken.getToken());
        return given()
                .header("Authorization","Basic "+authenticationToken.getToken())
                .body(ticket)
                .when()
                .post("/api/tickets")
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(Ticket.class);
    }

    public AuthenticationToken authenticate() {

        Userpass userpass = new Userpass();
        userpass.setUsername("admin");
        userpass.setPassword("adminat");

        AuthenticationToken authenticationToken = given()
                        .accept("application/json")
                        .contentType("application/json")
                        .body(userpass)
                        .expect()
                        .statusCode(200)
                        .when()
                        .post("/api/login")
                        .then()
                        .log().all()
                        .extract()
                        .body().as(AuthenticationToken.class);

        return authenticationToken;
    }
}
