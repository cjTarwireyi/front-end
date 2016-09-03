package ac.cj.cornelious.busbooking.config;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ac.cj.cornelious.busbooking.config.domain.Passenger;
import ac.cj.cornelious.busbooking.config.domain.PassengerAddress;
import ac.cj.cornelious.busbooking.config.factories.impl.PassengerAddressFactoryImpl;
import ac.cj.cornelious.busbooking.config.factories.impl.PassengerFactoryImpl;
import ac.cj.cornelious.busbooking.config.repositories.IPassengerRepository;
import ac.cj.cornelious.busbooking.config.repositories.impl.PassengerRepositoryImpl;
import ac.cj.cornelious.busbooking.config.repositories.impl.RestMethods;

import com.example.cornelious.busbooking.R;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class PassengerActivity extends Activity {
 //   private EditText  idNumber;
    private EditText name;
    private EditText lastName;
    private EditText street;
    private EditText city;
    private EditText code;
    private EditText searchId;
    private Button buttonSearch;
    Long id;
    private Button buttonToday ;


    private String key;
    private IPassengerRepository repo;
    Passenger passenger  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registercustomeractivity);


    //    button= (Button)findViewById(R.id.btnPreview);
        name = (EditText) findViewById(R.id.txtName);
        lastName = (EditText) findViewById(R.id.txtSurname);
        street = (EditText) findViewById(R.id.txtStreetName);
        city = (EditText) findViewById(R.id.txtCity);
        code = (EditText) findViewById(R.id.txtCode);
        buttonSearch = (Button) findViewById(R.id.btnSearch);
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
        DialogFragment dialogFragment;
        try {



            Intent getIntent=getIntent();
            Bundle bundle= getIntent.getExtras();
            key=(String)bundle.get("key");

            Intent intent = new Intent(getApplicationContext(), Previewpassenger.class);

            //intent.putExtra("idNumber", idNumber.getText().toString());
            //intent.putExtra("name", name.getText().toString());
            //intent.putExtra("lastname", lastName.getText().toString());
           // intent.putExtra("street", street.getText().toString());
           // intent.putExtra("code", code.getText().toString());
           // intent.putExtra("city", city.getText().toString());
            intent.putExtra("key",key);
            if(key.equals("ADD")){
            PassengerAddress address = new PassengerAddressFactoryImpl().createPassengerAddress(
                    street.getText().toString(),
                    code.getText().toString(),
                    city.getText().toString());
            Passenger newPassenger = new PassengerFactoryImpl().createPassenger(
                  //  idNumber.getText().toString(),
                    name.getText().toString(),
                    lastName.getText().toString(),
                    address);

                intent.putExtra("pass",newPassenger);
                startActivity(intent);
            }
            else if(key.equals("UPDATE"))
            {


                if(passenger!=null)
                {
                    PassengerAddress address = new PassengerAddress.AddressBuilder()
                            .copy(passenger.getObjAdress())
                            .street( street.getText().toString())
                            .city(city.getText().toString())
                            .code(lastName.getText().toString())
                            .build();
                    Passenger update = new Passenger.PassengerBuilder()
                            .copy(passenger)
                            .id(Long.parseLong(searchId.getText().toString()))
                            //.passNumber(idNumber.getText().toString())
                            .name(name.getText().toString())
                            .lastName(lastName.getText().toString())
                            .address(address)
                            .build();
                    intent.putExtra("key",key);
                    intent.putExtra("pass",update);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), "The record could not be found", Toast.LENGTH_LONG).show();
                }



            }


        }
        catch(NumberFormatException nfe)
        {
            Toast.makeText(getBaseContext(),"Make sure ID number and code are in number format",Toast.LENGTH_LONG).show();

        }
        catch (NullPointerException npe){
            Toast.makeText(getBaseContext(),"null",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){}
    }
    public Passenger SearchByID(View view){
        //repo= new PassengerRepositoryImpl(App.getContext());
      try {
          searchId=(EditText)findViewById(R.id.txtSearch);
         id =Long.parseLong(searchId.getText().toString());

          new HttpRequestTask().execute();
            Thread.sleep(5000);

         if (passenger!=null) {

             name = (EditText) findViewById(R.id.txtName);
             lastName = (EditText) findViewById(R.id.txtSurname);
             street = (EditText) findViewById(R.id.txtStreetName);
             city = (EditText) findViewById(R.id.txtCity);
             code = (EditText) findViewById(R.id.txtCode);

             street.setText(passenger.getObjAdress().getStreet());
             name.setText(passenger.getName());
             lastName.setText(passenger.getLastName());
             city.setText(passenger.getObjAdress().getCity());
             code.setText(passenger.getObjAdress().getCode());
             return passenger;
         }
          else{
             Toast.makeText(getBaseContext(), "The record could not be found", Toast.LENGTH_LONG).show();
             return  null;
         }

          //return passenger;
      }
      catch (NumberFormatException nfe){
          Toast.makeText(getBaseContext(), "Make sure your search id is a number", Toast.LENGTH_LONG).show();
          return  null;
      }
      catch (Exception e)
      {
          Toast.makeText(getBaseContext(), "something went wrong", Toast.LENGTH_LONG).show();
          return  null;
      }
    }
    public void clear(){
       // idNumber.setText("");
        name.setText("");
        lastName.setText("");
        street.setText("");
        city.setText("");
        code.setText("");
    }
    public void deletePassenger(View view){

       new   HttpDeleteTask().execute();
           clear();
           Toast.makeText(getBaseContext(), "successfully deleted", Toast.LENGTH_LONG).show();

    }
    private class HttpRequestTask extends AsyncTask<Void, Void, Passenger> {
        @Override
        protected Passenger doInBackground(Void... params) {
            try {

                final String BASE_URL = "http://148.100.5.107:8080/pass/{id}";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Passenger pass = restTemplate.getForObject(BASE_URL,Passenger.class,id+"");
                passenger = new Passenger.PassengerBuilder().copy(pass).build();


                return passenger;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

    }
    private class HttpDeleteTask extends AsyncTask<Void, Void, Passenger> {
        @Override
        protected Passenger doInBackground(Void... params) {
            try {

              final String BASE_URL = "http://148.100.5.107:8080/pass/{id}";
               RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpHeaders  headers = new HttpHeaders();
               // headers.setContentLength(MediaType.APPLICATION_JSON);
                Passenger pass = restTemplate.getForObject(BASE_URL,Passenger.class,id+"");
                restTemplate.delete(BASE_URL,id+"");
               //  passenger = new Passenger.PassengerBuilder().copy(pass).build();


                return passenger;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

    }


    }
