package com.example.arek.haslo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class UstawieniaActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    static final String HASLO = "com.example.arek.HASLO";
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);

        sharedPref = getSharedPreferences("DANE", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

    }

    public void zmienHaslo(View view){
        String stareHasloWlasciwe = sharedPref.getString(HASLO, "Nieznane");

        String stareHaslo = ((EditText) findViewById(R.id.stareHasloEdit)).getText().toString();

        if(stareHaslo.equals(stareHasloWlasciwe)){
            String noweHaslo1 = ((EditText) findViewById(R.id.noweHaslo1Edit)).getText().toString();
            String noweHaslo2 = ((EditText) findViewById(R.id.noweHaslo2Edit)).getText().toString();

            if(noweHaslo1.equals(noweHaslo2)){
                editor.putString(HASLO, noweHaslo1);
                editor.apply();
                //stareHasloWlasciwe = noweHaslo1;
                ((EditText) findViewById(R.id.noweHaslo1Edit)).setText("");
                ((EditText) findViewById(R.id.noweHaslo2Edit)).setText("");
                ((EditText) findViewById(R.id.stareHasloEdit)).setText("");

                Toast.makeText(this, "Zmieniono haslo", Toast.LENGTH_LONG).show();

            }else{
                new AlertDialog.Builder(this)
                        .setTitle("Podano dwa rozne hasla")
                        .setMessage("Podaj dwa takie same hasla")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ((EditText) findViewById(R.id.noweHaslo1Edit)).setText("");
                                ((EditText) findViewById(R.id.noweHaslo2Edit)).setText("");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }

        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Podano bledne haslo")
                    .setMessage("Podaj poprawne haslo!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((EditText) findViewById(R.id.stareHasloEdit)).setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }


    }


}
