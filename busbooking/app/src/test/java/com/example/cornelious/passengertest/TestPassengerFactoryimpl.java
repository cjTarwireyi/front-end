package com.example.cornelious.passengertest;

import ac.cj.cornelious.busbooking.config.factories.IPassengerFactory;
import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;
import ac.cj.cornelious.busbooking.config.factories.impl.PassengerFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class TestPassengerFactoryimpl {
    private static IPassengerFactory objPassengerFactory;
    private PassengerAddress address;
    @Before
    public void setUp() throws Exception {
        objPassengerFactory= new PassengerFactoryImpl().getInstance();

    }

    @Test
    public void testPassengerCreation() throws Exception {
        Passenger objPassenger=objPassengerFactory.createPassenger("123","Cornelious","Tarwireyi",address);
        Assert.assertEquals("123",objPassenger.getPassNumber());
        Assert.assertEquals("Cornelious",objPassenger.getName());
        Assert.assertEquals("Tarwireyi",objPassenger.getLastName());
    }

    @Test
    public void testPassengerUpdate() throws Exception {
        Passenger objPassenger=objPassengerFactory.createPassenger("123","Cornelious","Tarwireyi",address);
        Passenger objNewPassenger= new Passenger.PassengerBuilder()
                .copy(objPassenger)
                .passNumber("321")
                .name("cj")
                .lastName("junior")
                .build();
        Assert.assertEquals(objNewPassenger.getPassNumber(),"321");
        Assert.assertEquals(objNewPassenger.getName(),"cj");
        Assert.assertEquals(objNewPassenger.getLastName(),"junior");


    }
}
