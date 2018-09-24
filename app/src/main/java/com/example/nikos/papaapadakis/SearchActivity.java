package com.example.nikos.papaapadakis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class SearchActivity extends AppCompatActivity {

    private String jsonResult;
    public String url ="http://192.168.1.116/get.php";
    ListView listView;
    List<Map<String,String>> hotels = new ArrayList<Map<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String url="http://192.168.1.116/get.php";

        listView = (ListView) findViewById(R.id.listView);
        final Downloader d=new Downloader(this,url,listView);
        d.execute();






    }









}
