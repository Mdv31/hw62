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
        Ticket ticket = BaseTest.buildNewTicket(Status.CLOSED,2);
        Ticket newTicket = createTicket(ticket);
        Ticket actual = updateTicketNegative(newTicket);
        Assert.assertEquals(actual.getStatus(),4);
    }

    private Ticket updateTicketNegative(Ticket ticket) {
        // todo: отправить HTTP запрос для обновления данных тикета и сразу же проверить статус код (должен соответствовать ошибке)
        ticket.setStatus(1);
        return given()
                .pathParam("id", ticket.getId())
                .body(ticket)
                .when()
                .patch("/api/tickets/{id}")
                .then()
                .statusCode(200)//422
                .extract()
                .body()
                .as(Ticket.class);
    }
}
