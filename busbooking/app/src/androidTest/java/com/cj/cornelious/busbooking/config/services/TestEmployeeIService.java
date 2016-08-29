package com.cj.cornelious.busbooking.config.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import ac.cj.cornelious.busbooking.config.App;
import ac.cj.cornelious.busbooking.config.domain.EmpAddressVO;
import ac.cj.cornelious.busbooking.config.domain.Employee;
import ac.cj.cornelious.busbooking.config.repositories.impl.EmployeeRepoImpl;
import ac.cj.cornelious.busbooking.config.services.impl.EmployeeIntentService;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/10/2016.
 */
public class TestEmployeeIService extends AndroidTestCase {
private EmployeeRepoImpl objRepo;
    private Intent intent;
    private EmployeeIntentService service;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        service= new EmployeeIntentService();
      intent= new Intent(App.getContext(),EmployeeIntentService.class);
        objRepo=new EmployeeRepoImpl(App.getContext());
    }

    public void testAdd() throws Exception {

        EmpAddressVO addressVO=new EmpAddressVO.AddressBuilder()
                .street("capetown")
                .city("capetown")
                .code("1234")
                .build();
        Employee employee=new Employee.EmployeeBuilder()
                .Name("CJ")
                .lastName("cj")
                .id("12")
                .address(addressVO)
                .build();
service.addEmp(App.getContext(),employee );
        Set<Employee>employeeSet=objRepo.findAll();
        Employee found=objRepo.findById(0L);

        Assert.assertNotNull(found);
       Assert.assertEquals("TEST ADD",found.getEmpLastName(),"cj");
    }
}
