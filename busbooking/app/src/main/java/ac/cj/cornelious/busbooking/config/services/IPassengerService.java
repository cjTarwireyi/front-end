package ac.cj.cornelious.busbooking.config.services;

import android.content.Context;

import ac.cj.cornelious.busbooking.config.domain.Passenger;

/**
 * Created by Cornelious on 5/10/2016.
 */
public interface IPassengerService {
    void addPassenger(Context context,Passenger passenger);
    void updatePassenger(Context context,Passenger passenger);
}
