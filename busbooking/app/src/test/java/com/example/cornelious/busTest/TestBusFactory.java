package com.example.cornelious.busTest;

import ac.cj.cornelious.busbooking.config.domain.Bus;
import ac.cj.cornelious.busbooking.config.factories.impl.BusFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class TestBusFactory {
    private BusFactoryImpl objBusFactory;
    @Before
    public void setUp() throws Exception {
        objBusFactory= new BusFactoryImpl().getInstance();
    }

    @Test
    public void testBusCreation() throws Exception {
        Bus objBus =objBusFactory.createBus("CA123",72);
        Assert.assertEquals("CA123",objBus.getNumberPlate());
        Assert.assertEquals(72,objBus.getSeats());
    }

    @Test
    public void testBusUpdate() throws Exception {
        Bus objBus =objBusFactory.createBus("CA123",72);
        Bus newBus= new Bus.BusBuilder()
                .copy(objBus)
                .getnumberPlate("CA321")
                .seats(15)
                .build();
        Assert.assertEquals("CA321",newBus.getNumberPlate());
        Assert.assertEquals(15,newBus.getSeats());
    }
}
