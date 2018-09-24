package com.example.nikos.papaapadakis;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    EditText etusername, etpass, etname, etsurname, etemail, etphone, etcity, etstreet, ettk, etcardNumber;
    RadioButton etsex;
    String username, pass, name, surname, email, phone, city, street, tk, cardNumber;
    int code;
    InputStream is = null;
    String result = null;
    String line = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        etusername = (EditText) findViewById(R.id.editText);
        etpass = (EditText) findViewById(R.id.editText2);
        etsex = (RadioButton) findViewById(R.id.radioButton);
        etname = (EditText) findViewById(R.id.editText3);
        etsurname = (EditText) findViewById(R.id.editText4);
        etemail = (EditText) findViewById(R.id.editText5);
        etphone = (EditText) findViewById(R.id.editText6);
        etcity = (EditText) findViewById(R.id.editText7);
        etstreet = (EditText) findViewById(R.id.editText8);
        ettk = (EditText) findViewById(R.id.editText9);
        etcardNumber = (EditText) findViewById(R.id.editText10);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button submit = (Button) findViewById(R.id.button3);
        submit.setOnClickListener(new View.OnClickListener() {


            InputStream is = null;

            public void onClick(View v) {
                String username = "" + etusername.getText().toString();
                String pass = "" + etpass.getText().toString();
                String name = "" + etname.getText().toString();
                String surname = "" + etsurname.getText().toString();
                String email = "" + etemail.getText().toString();
                String phone = "" + etphone.getText().toString();
                String city = "" + etcity.getText().toString();
                String street = "" + etstreet.getText().toString();
                String tk = "" + ettk.getText().toString();
                String cardNumber = "" + etcardNumber.getText().toString();
                //insert();
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

                nameValuePairs.add(new BasicNameValuePair("username",username));
                nameValuePairs.add(new BasicNameValuePair("pass",pass));
                nameValuePairs.add(new BasicNameValuePair("name",name));
                nameValuePairs.add(new BasicNameValuePair("surname",surname));
                nameValuePairs.add(new BasicNameValuePair("email",email));
                nameValuePairs.add(new BasicNameValuePair("phone",phone));
                nameValuePairs.add(new BasicNameValuePair("city",city));
                nameValuePairs.add(new BasicNameValuePair("street",street));
                nameValuePairs.add(new BasicNameValuePair("tk",tk));
                nameValuePairs.add(new BasicNameValuePair("cardNumber", cardNumber));


                try {

                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httpost = new HttpPost ("http://192.168.1.116/insert.php");
                    httpost.setEntity (new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse responce = httpclient.execute(httpost);
                    HttpEntity entity = responce.getEntity();

                    is = entity.getContent();
                    String msg = "Data entered successfully";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG ).show();

                     }
                catch (ClientProtocolException e)
                {
                    Log.e("ClientProtocol", "Log_tag");
                    e.printStackTrace();
                }catch(IOException e )
                {
                    Log.e("Log_tag", "IOException");
                    e.printStackTrace();
                }


            }
        });
    }



}
