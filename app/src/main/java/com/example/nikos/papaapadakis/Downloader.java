package com.example.nikos.papaapadakis;

/**
 * Created by Nikos on 15/4/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
    /**
     * Created by Hp on 3/24/2016.
     */
    public class Downloader extends AsyncTask<Void,Integer,String> {
        Context c;
        String address;
        ListView lv;
        ProgressDialog pd;
        public Downloader(Context c, String address, ListView lv) {
            this.c = c;
            this.address = address;
            this.lv = lv;
        }
        //B4 JOB STARTS
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(c);
            pd.setTitle("Fetch Data");
            pd.setMessage("Fetching Data...Please wait");
            pd.show();
        }
        @Override
        protected String doInBackground(Void... params) {
            String data=downloadData();
            return data;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();;
            if(s != null)
            {
                Parser p=new Parser(c,s,lv);
                p.execute();
            }else
            {
                Toast.makeText(c,"Unable to download data",Toast.LENGTH_SHORT).show();
            }
        }
        private String downloadData()
        {
            //connect and get a stream
            InputStream is=null;
            String line =null;
            try {
                HttpParams params = new BasicHttpParams();
                params.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, HTTP.UTF_8);
// defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient(params);

                URL url=new URL(address);
                HttpURLConnection con= (HttpURLConnection) url.openConnection();
                is=new BufferedInputStream(con.getInputStream());
                BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                StringBuffer sb=new StringBuffer();
                if(br != null) {
                    while ((line=br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                }else {
                    return null;
                }
                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(is != null)
                {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
    }

