package ac.example.cornelious.busbooking.services;

import android.content.Context;

import ac.example.cornelious.busbooking.domain.ActivateTrip;

/**
 * Created by Cornelious on 5/12/2016.
 */
public interface IActivateTripService {
    public void addTrip(Context context,ActivateTrip activateTrip);
    public  void updateTrip(Context context,ActivateTrip activateTrip);
}
