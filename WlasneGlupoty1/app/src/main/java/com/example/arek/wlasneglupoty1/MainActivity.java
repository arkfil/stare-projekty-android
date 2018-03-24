package com.example.arek.wlasneglupoty1;

import android.database.DatabaseErrorHandler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

    //    db.addNote(new Notatka("tytul1","tresc1"));
    //    db.addNote(new Notatka("tytul2","tresc2"));

        List<Notatka> lista = db.getAllNotes();

        for(Notatka nt : lista){
            Log.i("BAZA",nt.getTytul());
        }


    }
}
