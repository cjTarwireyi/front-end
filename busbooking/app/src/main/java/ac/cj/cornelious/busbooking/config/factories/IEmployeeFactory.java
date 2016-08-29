package ac.cj.cornelious.busbooking.config.factories;

import ac.cj.cornelious.busbooking.config.domain.EmpAddressVO;
import ac.cj.cornelious.busbooking.config.domain.Employee;

/**
 * Created by Cornelious on 4/14/2016.
 */
public interface IEmployeeFactory {
    Employee createEmployee(Long employeeNumber,String empId, String name, String surname,EmpAddressVO objAddress);

}
