package com.example.arek.pierwszyprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TEST", "Uruchomiona metoda onCreate()");

    }

    protected void onStart(){
        super.onStart();
        Log.i("TEST", "Uruchomiona metoda onStart()");
    }
    protected void onStop(){
        super.onStop();
        Log.i("TEST", "Uruchomiona metoda onStop()");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i("TEST", "Uruchomiona metoda onDestroy()");
    }
    protected void onPause(){
        super.onPause();
        Log.i("TEST", "Uruchomiona metoda onPause()");
    }
    protected void onResume(){
        super.onResume();
        Log.i("TEST", "Uruchomiona metoda onResume()");
    }
    protected void onRestart(){
        super.onRestart();
        Log.i("TEST", "Uruchomiona metoda onRestart()");

    }
}
