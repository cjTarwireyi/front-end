package ac.cj.cornelious.busbooking.config.factories;

import ac.cj.cornelious.busbooking.config.domain.Ticket;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface ITicketFactory {

    Ticket createTicket(Long ticketNum, String ticketType, String route, double cost);
}
