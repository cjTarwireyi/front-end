package com.cj.cornelious.busbooking.config.services;

import android.test.AndroidTestCase;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class TestAccountBoundService extends AndroidTestCase {
   /* private AccountBoundService mService;
    private boolean status;
    AccountRepoImpl objRepo;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getContext(),AccountBoundService.class );
        App.getContext().bindService(intent,connection, Context.BIND_AUTO_CREATE);
        status=true;
        Toast.makeText(getContext(), "service binded successfully", Toast.LENGTH_LONG).show();
    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            AccountBoundService.LocalBinder binder =(AccountBoundService.LocalBinder)service;
            mService=binder.getService();
            status=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            status=false;
        }
    };
    public void testBusAdded() {



        String status = mService.activateAccount("cj","cj");
        Assert.assertEquals("ACCOUNT ACTIVATED", status);

    }*/
}
