package ac.cj.cornelious.busbooking.config;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.repositories.impl.PassengerRepositoryImpl;
import com.example.cornelious.busbooking.R;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Set;


public class DisplayRecords extends Activity {
    private PassengerRepositoryImpl objRepo;

    private ArrayList<String>passangerArray;
    private ArrayAdapter arrayAdapter;
    GridView passengerGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_records);
        //DBAdapter dbAdapter= new DBAdapter(this);
       // adap

        objRepo= new PassengerRepositoryImpl(App.getContext());
        passangerArray = new ArrayList<>();
        Cursor cursor = objRepo.getAll();

        if (cursor.moveToNext())
        {
            do{
                String id=cursor.getString(0);
                String name=cursor.getString(1);
                String lastName=cursor.getString(2);
                String street=cursor.getString(3);
                String city=cursor.getString(4);
                String code=cursor.getString(5);

                passangerArray.add(id);
                passangerArray.add(name);
               // passangerArray.add(lastName);
                passangerArray.add(street);
                //passangerArray.add(city);
                //passangerArray.add(code);
            }while (cursor.moveToNext());
            arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,passangerArray);

            passengerGridView=(GridView)findViewById(R.id.gridView);
            passengerGridView.setAdapter(arrayAdapter);




        }



    }
    private class HttpRequestTask extends AsyncTask<Void, Void, Passenger> {
        @Override
        protected Passenger doInBackground(Void... params) {
            try {
                final String BASE_URL = "http://148.100.5.107:8080/api/pass/findAll";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
               // Cursor greeting = restTemplate.getForObject(BASE_URL, Cursor.class);


                /*passangerArray = new ArrayList<>();
                Cursor cursor = restTemplate.getForObject(BASE_URL, Cursor.class);
                if (cursor.moveToNext())
                {
                    do{
                        String id=cursor.getString(0);
                        String name=cursor.getString(1);
                        String lastName=cursor.getString(2);
                        String street=cursor.getString(3);
                        String city=cursor.getString(4);
                        String code=cursor.getString(5);

                        passangerArray.add(id);
                        passangerArray.add(name);
                        // passangerArray.add(lastName);
                        passangerArray.add(street);
                        //passangerArray.add(city);
                        //passangerArray.add(code);
                    }while (cursor.moveToNext());
                    arrayAdapter=new ArrayAdapter<String>();

                    passengerGridView=(GridView)findViewById(R.id.gridView);
                    passengerGridView.setAdapter(arrayAdapter);*/

                    return null;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


    }
        public void goBackHome(View view) {
        Intent intent = new Intent(this,ActivityMain.class);
        startActivity(intent);
    }
}
