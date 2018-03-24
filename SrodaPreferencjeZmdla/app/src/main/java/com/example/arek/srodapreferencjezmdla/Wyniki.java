package com.example.arek.srodapreferencjezmdla;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Wyniki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyniki);

        TextView tv = (TextView) findViewById(R.id.wyniki);

        SharedPreferences sharedPref = getSharedPreferences("USTAWIENIA", Context.MODE_PRIVATE);

        String imie = sharedPref.getString(MainActivity.IMIE, "Nieznane");
        String nazwisko = sharedPref.getString(MainActivity.NAZWISKO, "Nieznane");

        tv.setText("Twoje dane: " + imie + " " + nazwisko);

    }
}
