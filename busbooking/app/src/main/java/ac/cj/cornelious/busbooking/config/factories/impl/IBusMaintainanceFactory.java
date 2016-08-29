package ac.cj.cornelious.busbooking.config.factories.impl;

import ac.cj.cornelious.busbooking.config.domain.Maintainance;

/**
 * Created by Cornelious on 4/17/2016.
 */
public interface IBusMaintainanceFactory {
    Maintainance createMaintainance(Long id, String maintainanceCode, String descrition, double cost);

}
