package com.example.cornelious.busbooking.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import ac.example.cornelious.busbooking.config.App;
import ac.example.cornelious.busbooking.domain.Ticket;
import ac.example.cornelious.busbooking.repositories.impl.TicketRepoImpl;
import ac.example.cornelious.busbooking.services.impl.TicketIntentService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/10/2016.
 */
public class TestTicketIntentService extends AndroidTestCase {
    private TicketIntentService ticketService;
    private TicketRepoImpl objRepo;
    Intent intent;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        ticketService=new TicketIntentService();
        intent= new Intent(App.getContext(),TicketIntentService.class);
        objRepo=new TicketRepoImpl(App.getContext());

    }
    public void testAdd(){

        Ticket objTicket= new Ticket.TicketBuilder()
                .cost(200.0)
                .route("CPT-JHB")
                .ticketType("Adult")
                .build();
        ticketService.addTicket(App.getContext(),objTicket);

        Ticket found=objRepo.findById(1L);
        Assert.assertNotNull("TEST ADD",found);
    }
}
