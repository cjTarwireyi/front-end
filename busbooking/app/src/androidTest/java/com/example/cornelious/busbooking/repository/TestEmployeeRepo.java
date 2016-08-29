package com.example.cornelious.busbooking.repository;

import android.test.AndroidTestCase;


import ac.cj.cornelious.busbooking.config.repositories.IEmployeeRepository;
import ac.cj.cornelious.busbooking.config.domain.EmpAddressVO;
import ac.cj.cornelious.busbooking.config.domain.Employee;

import ac.cj.cornelious.busbooking.config.repositories.impl.EmployeeRepoImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 4/20/2016.
 */
public class TestEmployeeRepo extends AndroidTestCase{
    private static final String TAG="Employee Test";
    private Long empNum;
    private IEmployeeRepository employeeRepository;

    public void testAddFindREmoveEdit(){
        employeeRepository = new EmployeeRepoImpl(this.getContext());
        //CREATING EMPLOYEE
        EmpAddressVO address = new EmpAddressVO.AddressBuilder()
                .street("oysterbay")
                .city("muizenberg")
                .code("7945")
                .build();
        Employee makeEmployee=new Employee.EmployeeBuilder()

                .id("23")
                .Name("Cornelious")
                .lastName("cj")
                .address(address)
                .build();
        Employee madeEmployee =employeeRepository.add(makeEmployee);
        empNum=madeEmployee.getEmployeeNumber();
        Assert.assertNotNull(TAG+" CREATING",madeEmployee);

        //READ ALL
        Set<Employee> employees=employeeRepository.findAll();
        Assert.assertTrue(TAG+" READ ALL",employees.size()>0);

        //FIND EMPLOYEE BY ID
        Employee EmployeeFound=employeeRepository.findById(empNum);

        Assert.assertNotNull(TAG+" FIND BY ID",EmployeeFound);

        //UPDATE

        Employee updatedEmployee=new Employee.EmployeeBuilder()
                .copy(EmployeeFound)
                .Name("cj")
                .build();
        employeeRepository.update(updatedEmployee);
        Employee newEmployee=employeeRepository.findById(empNum);
        Assert.assertEquals(TAG+" UPDATE","cj",newEmployee.getEmpName());

        //DELETE
        employeeRepository.remove(updatedEmployee);
        Employee employeeDelete =employeeRepository.findById(empNum);
                Assert.assertNull(TAG+"  DELETE", employeeDelete);

        //DELETE ALL
        employeeRepository.removeAll();
        Set<Employee> allEmployees=employeeRepository.findAll();
        Assert.assertEquals(TAG+" DELETE ALL",0,allEmployees.size());


    }
}

