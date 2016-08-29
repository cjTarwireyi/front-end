package ac.example.cornelious.busbooking.factories.impl;

import ac.example.cornelious.busbooking.factories.IEmployeeFactory;
import ac.example.cornelious.busbooking.domain.EmpAddressVO;
import ac.example.cornelious.busbooking.domain.Employee;

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
