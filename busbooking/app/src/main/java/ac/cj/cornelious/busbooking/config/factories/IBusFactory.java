package ac.cj.cornelious.busbooking.config.factories;

import ac.cj.cornelious.busbooking.config.domain.Bus;

/**
 * Created by Cornelious on 4/16/2016.
 */
public interface IBusFactory {
    Bus createBus(String numberPlate, int numberOfSeats);
}
