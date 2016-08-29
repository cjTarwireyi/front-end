package ac.example.cornelious.busbooking.factories;

import ac.example.cornelious.busbooking.domain.Ticket;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface ITicketFactory {

    Ticket createTicket(Long ticketNum, String ticketType, String route, double cost);
}
