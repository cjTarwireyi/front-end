package ac.example.cornelious.busbooking.factories;

import ac.example.cornelious.busbooking.domain.EmpAddressVO;
import ac.example.cornelious.busbooking.domain.PassengerAddress;

/**
 * Created by Cornelious on 4/15/2016.
 */
public abstract class IAddressFactory {
     public PassengerAddress createPassengerAddress(String street, String city, String code){return null;};

     public EmpAddressVO createEmployeeAddress(Long id, String street, String city, String code){return null;};
}
