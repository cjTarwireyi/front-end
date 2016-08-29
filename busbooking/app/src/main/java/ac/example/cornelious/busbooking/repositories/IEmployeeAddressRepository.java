package ac.example.cornelious.busbooking.repositories;



import ac.example.cornelious.busbooking.domain.EmpAddressVO;

/**
 * Created by Cornelious on 4/17/2016.
 */
public interface IEmployeeAddressRepository {
    EmpAddressVO addAddress (String key, EmpAddressVO objAddress);
    EmpAddressVO findAddress(String key);
    EmpAddressVO remove(String key);
}
