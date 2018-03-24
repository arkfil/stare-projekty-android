package com.example.arek.haslo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void zmianaHaslaActv(View view){
        Intent ustawieniaActivity = new Intent(this,UstawieniaActivity.class);
        startActivity(ustawieniaActivity);
    }

    public void infoAutorActv(View view){
        Intent autorActivity = new Intent(this,AutorActivity.class);
        startActivity(autorActivity);
    }


    public void stronaActv(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uek.krakow.pl"));
        startActivity(browserIntent);
    }

}
