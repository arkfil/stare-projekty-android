package com.example.arek.sekretnik;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class UstawieniaActivity extends AppCompatActivity {
    static final String HASLO = "com.example.arek.HASLO";
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String poprzednieHasloWlasciwe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);
        sharedPref = getSharedPreferences("DANE", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        poprzednieHasloWlasciwe = sharedPref.getString(HASLO, "Nieznane");
        if(poprzednieHasloWlasciwe.equals("Nieznane")){
            ((EditText)findViewById(R.id.poprzednieHaslo)).setEnabled(false);
        }
    }

    public void ustawHaslo(View view) {


        String pierwszeHaslo = ((EditText) findViewById(R.id.doZmHaslaText1)).getText().toString();

        String drugieHaslo = ((EditText) findViewById(R.id.doZmHaslaText2)).getText().toString();

        String poprzednieHasloPodane = ((EditText)findViewById(R.id.poprzednieHaslo)).getText().toString();

        if (poprzednieHasloWlasciwe.equals("Nieznane")) {
            if (pierwszeHaslo.equals(drugieHaslo)) {
                editor.putString(HASLO, drugieHaslo);
                editor.apply();
                poprzednieHasloWlasciwe=drugieHaslo;
                new AlertDialog.Builder(this)
                        .setTitle("Sukces")
                        .setMessage("Haslo zostalo zmienione")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ((TextView) findViewById(R.id.doZmHaslaText1)).setText("");
                                ((TextView) findViewById(R.id.doZmHaslaText2)).setText("");
                                ((TextView) findViewById(R.id.poprzednieHaslo)).setText("");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Wprowadziles dwa rozne hasla")
                        .setMessage("Wprowadz dwa takie same hasla")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ((TextView) findViewById(R.id.doZmHaslaText1)).setText("");
                                ((TextView) findViewById(R.id.doZmHaslaText2)).setText("");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }

        }else if(poprzednieHasloWlasciwe.equals(poprzednieHasloPodane)){
            if (pierwszeHaslo.equals(drugieHaslo)) {
                editor.putString(HASLO, drugieHaslo);
                editor.apply();
                poprzednieHasloWlasciwe=drugieHaslo;
                new AlertDialog.Builder(this)
                        .setTitle("Sukces")
                        .setMessage("Haslo zostalo zmienione")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ((TextView) findViewById(R.id.doZmHaslaText1)).setText("");
                                ((TextView) findViewById(R.id.doZmHaslaText2)).setText("");
                                ((TextView) findViewById(R.id.poprzednieHaslo)).setText("");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Wprowadziles dwa rozne hasla")
                        .setMessage("Wprowadz dwa takie same hasla")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ((TextView) findViewById(R.id.doZmHaslaText1)).setText("");
                                ((TextView) findViewById(R.id.doZmHaslaText2)).setText("");
                                ((TextView) findViewById(R.id.poprzednieHaslo)).setText("");
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        } else {

            new AlertDialog.Builder(this)
                    .setTitle("Podane stare haslo nie jest prawidlowe")
                    .setMessage("Wprowadz poprawne haslo")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((TextView) findViewById(R.id.poprzednieHaslo)).setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();



        }
    }

}
