package com.cj.cornelious.busbooking.config.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import ac.cj.cornelious.busbooking.config.App;
import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;
import ac.cj.cornelious.busbooking.config.repositories.impl.PassengerRepositoryImpl;
import ac.cj.cornelious.busbooking.config.services.impl.PassengerIntentService;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/10/2016.
 */
public class TestPassengerIService extends AndroidTestCase {
    private PassengerRepositoryImpl objRepo;
    private Intent intent;
    private PassengerIntentService service;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        service=new PassengerIntentService();
//        intent=new Intent(App.getContext(),PassengerIntentService.class);
        objRepo= new PassengerRepositoryImpl(App.getContext());
    }
    public void testAdd(){

        PassengerAddress address=new PassengerAddress.AddressBuilder()
                .street("11 capeTown")
                .city("capetown")
                .code("8000")
                .build();
        Passenger passenger= new Passenger.PassengerBuilder()
                .name("cj")
                .lastName("cj")
                .passNumber("1")
                .address(address)
                .build();

        service.addPassenger(App.getContext(), passenger);
        Set<Passenger> passengerSet=objRepo.findAll();
        Passenger found= objRepo.findById(1L);

        Assert.assertTrue("TEST ADD",passengerSet.size()>0);
        Assert.assertEquals(found.getObjAdress().getCity(),"capetown");
    }
}
