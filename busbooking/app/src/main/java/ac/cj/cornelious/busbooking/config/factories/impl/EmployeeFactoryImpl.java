package ac.cj.cornelious.busbooking.config.factories.impl;

import ac.cj.cornelious.busbooking.config.factories.IEmployeeFactory;
import ac.cj.cornelious.busbooking.config.domain.EmpAddressVO;
import ac.cj.cornelious.busbooking.config.domain.Employee;

/**
 * Created by Cornelious on 4/15/2016.
 */
public class EmployeeFactoryImpl implements IEmployeeFactory {
    private static EmployeeFactoryImpl objEmpFactory=null;

    public IEmployeeFactory getInstance()
    {
        if (objEmpFactory==null)
            objEmpFactory=new EmployeeFactoryImpl();
        return objEmpFactory;
    }

    @Override
    public Employee createEmployee(Long employeeNumber,String empId, String empName, String empSurname,EmpAddressVO objAddress) {
        Employee objEmployee = new Employee.EmployeeBuilder()
                .employeeNumber(employeeNumber)
                .id(empId)
                .Name(empName)
                .lastName(empSurname)
                .address(objAddress)
                .build();
        return objEmployee;
    }
}
