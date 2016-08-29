package com.example.cornelious.busbooking.repository;

import android.test.AndroidTestCase;

import ac.cj.cornelious.busbooking.config.repositories.IPassengerRepository;

import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;
import ac.cj.cornelious.busbooking.config.repositories.impl.PassengerRepositoryImpl;

import junit.framework.Assert;


import java.util.Set;

/**
 * Created by Cornelious on 4/22/2016.
 */
public class TestPassengerRepo extends AndroidTestCase{
    private static   final String TAG="TESTING PASSENGER";
    private long empNum;

    private IPassengerRepository passengerRepository;
    public  void testAddFindREmoveEdit(){

       passengerRepository= new PassengerRepositoryImpl(this.getContext());

        //TEST CREATING
        PassengerAddress address = new PassengerAddress.AddressBuilder()
                .street("falsebay")
                .city("capeTown")
                .code("8000")
                .build();
        Passenger objPassenger= new Passenger.PassengerBuilder()
                .passNumber("1")
                .name("Cornelious")
                .lastName("cj")
                .address(address)
                .build();
      Passenger addedPassenger=  passengerRepository.add(objPassenger);
        empNum=addedPassenger.id();
        Assert.assertNotNull(TAG + " CREATING", addedPassenger);

        //FINDBY ID
        Passenger foundPassenger=passengerRepository.findById(empNum);
        Assert.assertNotNull(TAG+" FIND BY ID",foundPassenger);

        //UPDATE
        Passenger updatePassenger= new Passenger.PassengerBuilder()
                .copy(addedPassenger)
                .lastName("Mahara")
                .build();
        passengerRepository.update(updatePassenger);
        Passenger newPassenger=passengerRepository.findById(empNum);
        Assert.assertEquals(TAG + " TEST UPDATE", "Mahara", newPassenger.getLastName());

        //FIND ALL
        Set<Passenger> passengerSet;
        passengerSet=passengerRepository.findAll();
        Assert.assertTrue(TAG + " FIND ALL", passengerSet.size() > 0);


        //DELETE
        passengerRepository.remove(updatePassenger);
        Passenger deletedPassenger =passengerRepository.findById(empNum);
        Assert.assertNull(TAG + " DELETE", deletedPassenger);

        //DELETE ALL
        passengerRepository.removeAll();
        Set<Passenger> passengerSetAll;
        passengerSetAll=passengerRepository.findAll();
        Assert.assertTrue(TAG + " DELETE ALL", passengerSetAll.size() ==0);
    }
}
