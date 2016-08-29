package com.cj.cornelious.busbooking.config.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import ac.cj.cornelious.busbooking.config.App;
import ac.cj.cornelious.busbooking.config.domain.Maintainance;
import ac.cj.cornelious.busbooking.config.repositories.impl.MaintainanceRepoImpl;
import ac.cj.cornelious.busbooking.config.services.impl.MaintainanceIntentService;

import junit.framework.Assert;

/**
 * Created by Cornelious on 5/10/2016.
 */
public class TestMaintainanIService extends AndroidTestCase {
    private MaintainanceRepoImpl objRepo;
    private Intent intent  ;
    private MaintainanceIntentService service;
    @Override
    public void setUp() throws Exception {
        super.setUp();
       // intent = new Intent(App.getContext(),MaintainanceIntentService.class);
        service= new MaintainanceIntentService();
        objRepo=new MaintainanceRepoImpl(App.getContext());
    }
    public void testAdd(){
        Maintainance maintainance= new Maintainance.BuildMaintainance()
                .code("12")
                .cost(100.0)
                .Description("Tyer")
                .build();
        service.addMaintainance(App.getContext(), maintainance);

        Maintainance found =objRepo.findById(1L);
        Assert.assertEquals("TEST ADD",found.getDescription(),"Tyer");
    }
}
