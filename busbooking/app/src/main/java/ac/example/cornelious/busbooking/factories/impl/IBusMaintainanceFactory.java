package ac.example.cornelious.busbooking.factories.impl;

import ac.example.cornelious.busbooking.domain.Maintainance;

/**
 * Created by Cornelious on 4/17/2016.
 */
public interface IBusMaintainanceFactory {
    Maintainance createMaintainance(Long id, String maintainanceCode, String descrition, double cost);

}
