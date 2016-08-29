package com.cj.cornelious.busbooking.config.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import ac.cj.cornelious.busbooking.config.App;
import ac.cj.cornelious.busbooking.config.domain.Supplier;
import ac.cj.cornelious.busbooking.config.repositories.impl.SupplierRepoImpl;
import ac.cj.cornelious.busbooking.config.services.impl.SupplierIntentServiceImpl;

import org.junit.Assert;

import java.util.Set;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class TestSupplierIService extends AndroidTestCase {
    private SupplierRepoImpl objRepo;
    private Intent intent;
    private SupplierIntentServiceImpl service;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        service=new SupplierIntentServiceImpl();
//        intent=new Intent(App.getContext(),PassengerIntentService.class);
        objRepo= new SupplierRepoImpl(App.getContext());

    }
    public void testAdd(){

        Supplier supplier=new Supplier.SupplierBuilder()
                .name("cj")
                .contactNumber("123")
                .build();
        service.addPassenger(App.getContext(),supplier);

        Set<Supplier> supplierSet=objRepo.findAll();
        Supplier found= objRepo.findById(1L);

        Assert.assertTrue("TEST ADD", supplierSet.size() >0);

    }
}
