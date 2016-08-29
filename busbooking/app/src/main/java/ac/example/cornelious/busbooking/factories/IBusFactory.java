package ac.example.cornelious.busbooking.factories;

import ac.example.cornelious.busbooking.domain.Bus;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface IBusFactory {
    Bus createBus(String numberPlate, int numberOfSeats);
}
