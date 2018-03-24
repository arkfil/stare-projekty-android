package com.example.arek.haslo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    static final String HASLO = "com.example.arek.HASLO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = getSharedPreferences("DANE", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        String haslo = sharedPref.getString(HASLO, "Nieznane");

        if(haslo.equals("Nieznane")){
            setContentView(R.layout.glowny_nieustawione);
        }else{
            setContentView(R.layout.glowny_ustawione);
        }


    }

    public void ustawHaslo(View view){

        String noweHaslo = ((EditText) findViewById(R.id.noweHasloEdit)).getText().toString();
        String noweHaslo2 = ((EditText) findViewById(R.id.noweHasloEdit2)).getText().toString();


        if(noweHaslo.equals(noweHaslo2)){
            editor.putString(HASLO, noweHaslo);
            editor.apply();
            Toast.makeText(this, "Ustawiono haslo", Toast.LENGTH_LONG).show();

            Intent menuActivity = new Intent(this,MenuActivity.class);
            startActivity(menuActivity);


        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Podano dwa rozne hasla")
                    .setMessage("Podaj dwa takie same hasla")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((EditText) findViewById(R.id.noweHasloEdit)).setText("");
                            ((EditText) findViewById(R.id.noweHasloEdit2)).setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }


    }

    public void zaloguj(View view){
        String hasloPodane = ((EditText) findViewById(R.id.hasloWlasciweEdit)).getText().toString();

        String hasloWlasciwe = sharedPref.getString(HASLO, "Nieznane");

        if(hasloPodane.equals(hasloWlasciwe)){

            Intent menuActivity = new Intent(this,MenuActivity.class);
            startActivity(menuActivity);

        }else{

            new AlertDialog.Builder(this)
                    .setTitle("Bledne haslo")
                    .setMessage("Podaj poprawne haslo")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((EditText) findViewById(R.id.hasloWlasciweEdit)).setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
    }

}
