package ac.example.cornelious.busbooking.factories;

import ac.example.cornelious.busbooking.domain.EmpAddressVO;
import ac.example.cornelious.busbooking.domain.Employee;

/**
 * Created by Cornelious on 4/14/2016.
 */
public interface IEmployeeFactory {
    Employee createEmployee(Long employeeNumber,String empId, String name, String surname,EmpAddressVO objAddress);

}
