package ac.example.cornelious.busbooking.services;

import android.content.Context;

import ac.example.cornelious.busbooking.domain.Supplier;

/**
 * Created by Cornelious on 5/12/2016.
 */
public interface ISupplierIntentService {
    void addPassenger(Context context,Supplier supplier);
    void updatePassenger(Context context,Supplier supplier);
}
