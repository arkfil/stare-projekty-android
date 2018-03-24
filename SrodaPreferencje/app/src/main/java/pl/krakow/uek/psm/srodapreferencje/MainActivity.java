package pl.krakow.uek.psm.srodapreferencje;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    static final String IMIE = "pl.krakow.uek.psm.IMIE";
    static final String NAZWISKO = "pl.krakow.uek.psm.NAZWISKO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glowny);

        TextView tv = (TextView) findViewById(R.id.dane);

        SharedPreferences sharedPref = getSharedPreferences("USTAWIENIA", Context.MODE_PRIVATE);

        String imie = sharedPref.getString(IMIE, "Nieznane");
        String nazwisko = sharedPref.getString(NAZWISKO, "Nieznane");

        tv.setText("Twoje dane: " + imie + " " + nazwisko);

    }

    public void zapisz(View view) {

//        EditText et = (EditText) findViewById(R.id.imie);
//        String imie = et.getText().toString();
//
//        et = (EditText) findViewById(R.id.nazwisko);
//        String nazwisko = et.getText().toString();
//
//        SharedPreferences sharedPref = getSharedPreferences("USTAWIENIA", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString(IMIE, imie);
//        editor.putString(NAZWISKO, nazwisko);
//
//        editor.apply();
//
//        Intent intent = new Intent(this, Wyniki.class);
//        startActivity(intent);

        String filename = "test.txt";
        String string = "Witaj świecie!";

        // pamięć zewnętrzna
        File file = new File(getExternalFilesDir(null), filename);

        // pamięć wewnętrzna
        //File file = new File(getFilesDir(), filename);

        try {

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(string.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
