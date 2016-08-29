package ac.cj.cornelious.busbooking.config.factories;

import ac.cj.cornelious.busbooking.config.domain.EmpAddressVO;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;

/**
 * Created by Cornelious on 4/15/2016.
 */
public abstract class IAddressFactory {
     public PassengerAddress createPassengerAddress(String street, String city, String code){return null;};

     public EmpAddressVO createEmployeeAddress(Long id,String street, String city, String code){return null;};
}
