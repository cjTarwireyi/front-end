package ac.cj.cornelious.busbooking.config.factories;

import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface IPassengerFactory {
    Passenger createPassenger( String passengerName, String passengerSurname,PassengerAddress obAddress);
}
