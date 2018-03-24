package com.example.arek.testowaniemetodypost;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    public static final int PLEASE_WAIT_DIALOG = 1;
    TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tw = (TextView) findViewById(R.id.textView1);
    }

    public void dzialaj(View view) {

        HashMap<String, String> hr = new HashMap<String, String>();
        hr.put("nazwa","arek");
        hr.put("haslo","arek");
        InnyWatek a = new InnyWatek(MainActivity.this,"http://enecio.heliohost.org/pobierzwpisy.php/",hr);
        try {
            String str = a.execute().get();
            tw.setText(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}
