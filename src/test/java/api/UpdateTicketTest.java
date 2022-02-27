package api;

import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Обновление тикета */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        // todo: создать тикет со статусом Closed, затем обновить тикет и проверить сообщение об ошибке (негативный сценарий)
        Ticket ticket = BaseTest.buildNewTicket(Status.OPEN,2);
        Ticket newTicket = createTicket(ticket);
        Ticket actual = updateTicketNegative(newTicket);
        //System.out.println(newTicket.hashCode());
        //System.out.println(actual.hashCode());
        Assert.assertEquals(newTicket.hashCode(),actual.hashCode());
    }

    private Ticket updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)
        ticket.setStatus(1);
        return given()
                .pathParam("id", ticket.getId())
                .body(ticket)
                .when()
                .put("/api/tickets/{id}")
                .then()
                .statusCode(422)//422
                .extract()
                .body()
                .as(Ticket.class);
    }
}
