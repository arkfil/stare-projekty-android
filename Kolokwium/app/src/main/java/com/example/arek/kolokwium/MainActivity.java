package com.example.arek.kolokwium;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wywolajEdytor(View view){
        Intent edytorActv = new Intent(this,EdytorActivity.class);
        startActivity(edytorActv);
    }
    public void wywolajAutor(View view){
        Intent autorActv = new Intent(this,AutorActivity.class);
        startActivity(autorActv);
    }
    public void otworzEmail(View view){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Mail z aplikacji mobilnej");
        i.putExtra(Intent.EXTRA_TEXT   , "Zgłaszam następujące uwagi:");
        try {
            startActivity(Intent.createChooser(i, "Wyslij mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Klient email nie jest zainstalowany.", Toast.LENGTH_SHORT).show();
        }


    }

}
