package ac.cj.cornelious.busbooking.config.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import ac.cj.cornelious.busbooking.config.App;
import ac.cj.cornelious.busbooking.config.domain.Ticket;
import ac.cj.cornelious.busbooking.config.repositories.impl.TicketRepoImpl;

//An Intent service is used because rhere is no need for a result to be returned to the caller
public class TicketIntentService extends IntentService {

    private static final String ACTION_ADD = "com.cj.cornelious.busbooking.config.services.impl.action.ADD";
    private static final String ACTION_UPDATE = "com.cj.cornelious.busbooking.config.services.impl.action.UPDATE";


    private static final String EXTRA_ADD = "com.cj.cornelious.busbooking.config.services.impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.cj.cornelious.busbooking.config.services.impl.extra.UPDATE";

    private  final TicketRepoImpl objRepo;
    private static  TicketIntentService service=null;

    public static TicketIntentService getInstance(){
        if (service==null)
            service=new TicketIntentService();
            return  service;
    }

    public TicketIntentService() {
        super("TicketIntentService");
        objRepo=new TicketRepoImpl(App.getContext());
    }


    public void addTicket(Context context,Ticket ticket) {
        Intent intent = new Intent(context, TicketIntentService.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, ticket);

        context.startService(intent);
    }


    public  void updateTicket(Context context,Ticket ticket) {
        Intent intent = new Intent(context, TicketIntentService.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, ticket);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Ticket ticket =(Ticket) intent.getSerializableExtra(EXTRA_ADD);

                objRepo.add(ticket);
            } else if (ACTION_UPDATE.equals(action)) {
                final Ticket ticket =(Ticket) intent.getSerializableExtra(EXTRA_UPDATE);

                objRepo.update(ticket);
            }
        }
    }



}
