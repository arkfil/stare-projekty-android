package com.example.arek.testbasic;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class DodajWpisActivity extends AppCompatActivity {
    HashMap<String, String> parametryZapytaniaPOST;
    Serwer serwer;

    static final String DODAWANIE_WPISU_URL="http://enecio.heliohost.org/dodajwpis.php/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wpis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void dodajWpis(View view){
        String kod = "4470a6102e87eaa9748f63aa1d164596";
        String tytulStr = ((EditText) findViewById(R.id.tytulEditText)).getText().toString();
        String trescStr = ((EditText) findViewById(R.id.trescEditText)).getText().toString();


        parametryZapytaniaPOST = new HashMap<String, String>();
        parametryZapytaniaPOST.put("kod",kod);
        parametryZapytaniaPOST.put("temat",tytulStr);
        parametryZapytaniaPOST.put("tresc",trescStr);

        serwer = new Serwer(DodajWpisActivity.this,DODAWANIE_WPISU_URL, parametryZapytaniaPOST);
        String idNowegoWpisu="pusty";
        try {
            idNowegoWpisu = serwer.execute().get();
            Log.d("logik", "idNowegoWpisu"+idNowegoWpisu);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(!idNowegoWpisu.equals("2x")&&!idNowegoWpisu.equals("2x2x")&&!idNowegoWpisu.equals("3x")
                &&!idNowegoWpisu.equals("2x3x")&&!idNowegoWpisu.equals("2x2x3x")
                &&!idNowegoWpisu.isEmpty()&&!idNowegoWpisu.equals("pusty")){

            Intent returnIntent = new Intent();
            returnIntent.putExtra("result",idNowegoWpisu);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }else{
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
    }

    public void anuluj(View view){
        onBackPressed();
    }



}
