package com.example.arek.edytor;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EdytorActivity extends AppCompatActivity {

    final static String nazwaPliku = "plik.txt";

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytor);

    }


    public void zapiszPlik(View view){
        EditText et = (EditText) findViewById(R.id.trescText);

        String string = et.getText().toString();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(nazwaPliku, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast.makeText(this, "Zapisano do pliku", Toast.LENGTH_LONG).show();
    }

    public void odczytajPlik(View view){
        EditText et = ((EditText) findViewById(R.id.trescText));

        FileInputStream inputStream;

        String trescPliku="";


        try {
            inputStream = openFileInput(nazwaPliku);
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNextLine()){
                trescPliku+=sc.nextLine();
                trescPliku+="\n";
            }
            et.setText(trescPliku);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast.makeText(this, "Wczytano z pliku", Toast.LENGTH_LONG).show();
    }

    public void wyczysc(View view){
        EditText et = ((EditText) findViewById(R.id.trescText));
        et.setText("");
        Toast.makeText(this, "Wyczyszczono", Toast.LENGTH_LONG).show();


    }


}
