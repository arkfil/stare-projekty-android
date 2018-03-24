package com.example.arek.planuek;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String url="":




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        new ReadXMLTask().execute();

    }


    private class ReadXMLTask extends AsyncTask<String, Void, String>{

    }



    protected void onPostExecute(){

    }
}
