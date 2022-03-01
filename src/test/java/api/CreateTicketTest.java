package api;

import model.AuthenticationToken;
import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Создание и проверка тикета */
public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        // todo: создать тикет и проверить, что он находится в системе
        Ticket ticket = BaseTest.buildNewTicket(Status.OPEN,2);
        Ticket newTicket = createTicket(ticket);
        Ticket actual = getTicket(newTicket.getId());
        //System.out.println(newTicket.hashCode());
        //System.out.println(actual.hashCode());
        Assert.assertEquals(newTicket.hashCode(),actual.hashCode());
    }

    protected Ticket getTicket(int id) {
        // todo: отправить HTTP запрос на получение тикета по его id
        AuthenticationToken authenticationToken=authenticate();
        return given()
                .pathParam("id", id)
                .header("Authorization","Token "+authenticationToken.getToken())
                .when()
                .get("/api/tickets/{id}")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Ticket.class);
    }
}
