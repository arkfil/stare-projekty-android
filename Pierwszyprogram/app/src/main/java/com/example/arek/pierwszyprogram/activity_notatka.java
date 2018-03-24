package com.example.arek.pierwszyprogram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class activity_notatka extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notatka);
    }

    public void wyslij(View view) {
        Intent inte = getIntent();
        //Przekazywanie danych miedzy aktywnosciami

        EditText ed = (EditText) findViewById(R.id.odbiorca);
        ed.setText("Dane: ");

        AlertDialog al = new AlertDialog.Builder(activity_notatka.this).create();
        al.setTitle("Wysylanie");
        al.setMessage("Udalo sie wys;ac");

        al.show();
    }
}
