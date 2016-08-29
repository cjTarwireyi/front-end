package ac.cj.cornelious.busbooking.config.services;

import android.content.Context;

import ac.cj.cornelious.busbooking.config.domain.Bus;

/**
 * Created by Cornelious on 5/10/2016.
 */
public interface IBusIntentService {
      void addBus(Context context,Bus bus);
      void updateBus(Context context,Bus bus);
}
