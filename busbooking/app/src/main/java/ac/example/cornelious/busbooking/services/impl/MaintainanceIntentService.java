package ac.example.cornelious.busbooking.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import ac.example.cornelious.busbooking.config.App;
import ac.example.cornelious.busbooking.domain.Maintainance;
import ac.example.cornelious.busbooking.repositories.impl.MaintainanceRepoImpl;
import ac.example.cornelious.busbooking.services.IMaintainanceService;

//An Intent service is used because rhere is no need for a result to be returned to the caller
public class MaintainanceIntentService extends IntentService implements IMaintainanceService{

    private static final String ACTION_ADD = "com.example.cornelious.busbooking.services.impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.cornelious.busbooking.services.impl.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.example.cornelious.busbooking.services.impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.cornelious.busbooking.services.impl.extra.UPDATE";

    private final MaintainanceRepoImpl objRepo;
    private MaintainanceIntentService service= null;

    public MaintainanceIntentService getInstance(){
        if(service==null)
            service= new MaintainanceIntentService();
        return  service;
    }
    public MaintainanceIntentService() {
        super("MaintainanceIntentService");
        objRepo= new MaintainanceRepoImpl(App.getContext());
    }

@Override
public void addMaintainance(Context context, Maintainance maintainance) {
        Intent intent = new Intent(context, MaintainanceIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, maintainance);

        context.startService(intent);
    }


    public void updateMaintainance(Context context, Maintainance maintainance) {
        Intent intent = new Intent(context, MaintainanceIntentService.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, maintainance);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Maintainance objMaintainance = (Maintainance) intent.getSerializableExtra(EXTRA_ADD);

               objRepo.add(objMaintainance);
            } else if (ACTION_UPDATE.equals(action)) {
                final Maintainance objMaintanance = (Maintainance) intent.getSerializableExtra(EXTRA_UPDATE);

                objRepo.update(objMaintanance);
            }
        }
    }


}
