package ac.cj.cornelious.busbooking.config;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;
import ac.cj.cornelious.busbooking.config.repositories.RestAPI;
import ac.cj.cornelious.busbooking.config.repositories.impl.PassengeRestApi;
import ac.cj.cornelious.busbooking.config.repositories.impl.PassengerRepositoryImpl;
import ac.cj.cornelious.busbooking.config.services.impl.PassengerApiService;
import ac.cj.cornelious.busbooking.config.services.impl.PassengerIntentService;
import com.example.cornelious.busbooking.R;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;


public class Previewpassenger extends Activity {
    // private TextView idNumber;
    private TextView name;
    private TextView lastName;
    private TextView street;
    private TextView city;
    private TextView code;
    //private PassengerRepositoryImpl objRepo;
    private PassengerApiService service;
    private String key;
    private Passenger passenger;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previewpassenger);
       // final RestAPI<Passenger, Long> rest = new PassengeRestApi();
        // idNumber=(TextView)findViewById(R.id.txtID);
        name = (TextView) findViewById(R.id.txtName);
        lastName = (TextView) findViewById(R.id.txtLastName);
        street = (TextView) findViewById(R.id.txtStreet);
        city = (TextView) findViewById(R.id.txtCity);
        code = (TextView) findViewById(R.id.txtCode);
        intent = getIntent();
        //service = new PassengerApiService();
        bundle = intent.getExtras();
        if (bundle != null) {
            passenger = ((Passenger) bundle.get("pass"));
            key = (String) bundle.get("key");
            //idNumber.setText(passenger.getPassNumber());
            name.setText(passenger.getName());
            lastName.setText(passenger.getLastName());
            street.setText(passenger.getObjAdress().getStreet());
            city.setText(passenger.getObjAdress().getCity());
            code.setText(passenger.getObjAdress().getStreet());


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_previewpassenger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addPassenger(View view) {
if(key.equals("ADD")) {

    new HttpRequestTask().execute();
}else{
    new HttpUpdateTask().execute();
}
        Intent intent = new Intent(this, DisplayRecords.class);
        startActivity(intent);
    }


      private    class HttpRequestTask extends AsyncTask<Void, Void, Passenger> {
            @Override
            protected Passenger doInBackground(Void... params) {
                try {
                    final String BASE_URL = "http://148.100.5.107:8080/api/pass";


                    RestTemplate rest = new RestTemplate();
                    rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    HttpEntity<Passenger> request = new HttpEntity<>(passenger, headers);
                    Passenger user = rest.postForObject(BASE_URL, request, Passenger.class);




                    return passenger;
                } catch (Exception e) {
                        Log.e("MainActivity", e.getMessage(), e);
                    }

                    return null;

                }

        }

    private class HttpUpdateTask extends AsyncTask<Void, Void, Passenger> {
        @Override
        protected Passenger doInBackground(Void... params) {
            try {

                if (bundle != null) {

                    final String BASE_URLU = "http://148.100.5.107:8080/pass/";
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                    // Passenger pass = restTemplate.put(BASE_URLU, Passenger.class, id + "");
                    restTemplate.put(BASE_URLU, passenger);
                }

                return passenger;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

    }
    }

/*public class HttpRequestTask extends AsyncTask<Void, Void, Passenger> {
    @Override
    protected Passenger doInBackground(Void... params) {
        try {
            final String url = "http://rest-service.guides.spring.io/greeting";

            bundle = intent.getExtras();
            service = new PassengerApiService();
            // objRepo = new PassengerRepositoryImpl(App.getContext());

            key = (String) bundle.get("key");

            if (key.equals("ADD")) {
                service.save( passenger);
            } else if (key.equals("UPDATE")) {
                service.update(passenger);
                Toast.makeText(getBaseContext(), "updated", Toast.LENGTH_LONG).show();
            }


                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    Passenger greeting = restTemplate.postForObject(url, Passenger.class);
            return passenger;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;


    }

    @Override
    protected void onPostExecute(Passenger passenger) {

    }

}*/