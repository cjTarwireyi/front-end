package ac.example.cornelious.busbooking.services;

import android.content.Context;

import ac.example.cornelious.busbooking.domain.Ticket;

/**
 * Created by Cornelious on 5/10/2016.
 */
public interface ITicketIntentService {
     void addTicket(Context context,Ticket ticket);
     void updateTicket(Context context,Ticket ticket);
}
