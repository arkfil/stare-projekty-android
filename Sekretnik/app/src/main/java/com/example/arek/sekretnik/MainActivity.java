package com.example.arek.sekretnik;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glowny);
    }

    public void serketActivity(View view){
        Intent preSekretActv = new Intent(this,PreSekretActivity.class);
        startActivity(preSekretActv);
    }

    public void pokazStrone(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pudelek.pl"));
        startActivity(browserIntent);
    }

    public void ustawieniaActivity(View view){
        Intent ustawieniaActv = new Intent(this,UstawieniaActivity.class);
        startActivity(ustawieniaActv);
    }

    public void autorActivity(View view){
        Intent autorActv = new Intent(this,AutorActivity.class);
        startActivity(autorActv);
    }






}
