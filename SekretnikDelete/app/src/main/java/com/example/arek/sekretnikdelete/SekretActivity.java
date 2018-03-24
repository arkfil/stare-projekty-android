package com.example.arek.sekretnikdelete;

        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

        import android.widget.Toast;

        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.util.Scanner;


public class SekretActivity extends AppCompatActivity {

    final static String nazwaPliku = "NatiSekret.txt";

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekret);

        EditText et = ((EditText) findViewById(R.id.sekretText));

        FileInputStream inputStream;

        String trescPliku="";


        try {
            inputStream = openFileInput(nazwaPliku);
            //   et.setText(new Scanner(inputStream).nextLine());
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


        Toast.makeText(this, "Wczytano sekret", Toast.LENGTH_LONG).show();

    }


    public void zapiszSekret(View view){
        EditText et = (EditText) findViewById(R.id.sekretText);

        String string = et.getText().toString();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(nazwaPliku, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast.makeText(this, "Zapisano plik", Toast.LENGTH_LONG).show();
    }

}
