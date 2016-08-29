package ac.example.cornelious.busbooking.factories;

import ac.example.cornelious.busbooking.domain.Passenger;
import ac.example.cornelious.busbooking.domain.PassengerAddress;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface IPassengerFactory {
    Passenger createPassenger(String passengerId, String passengerName, String passengerSurname, PassengerAddress obAddress);
}
