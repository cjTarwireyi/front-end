package ac.example.cornelious.busbooking.factories.impl;

import ac.example.cornelious.busbooking.factories.IPassengerFactory;
import ac.example.cornelious.busbooking.domain.Passenger;
import ac.example.cornelious.busbooking.domain.PassengerAddress;

/**
 * Created by Cornelious on 4/16/2016.
 */
public class PassengerFactoryImpl implements IPassengerFactory {
   private static PassengerFactoryImpl objPassengerFactory=null;
    public IPassengerFactory getInstance()
    {
        if (objPassengerFactory==null)
            objPassengerFactory= new PassengerFactoryImpl();
        return objPassengerFactory;
    }
    @Override
    public Passenger createPassenger(String passNumber, String passengerName, String passengerSurname, PassengerAddress obAddress) {
        Passenger objPassenger=new Passenger.PassengerBuilder()
                .passNumber(passNumber)

                .name(passengerName)
                .lastName(passengerSurname)
                .address(obAddress)
                .build();
        return objPassenger;
    }
}
