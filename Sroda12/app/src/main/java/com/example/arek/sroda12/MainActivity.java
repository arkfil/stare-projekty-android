package com.example.arek.sroda12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glowna);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView tv = (TextView) findViewById(R.id.wyniki);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String fontSize = sp.getString("pref_fontSize","12");
        boolean opis = sp.getBoolean("pref_opis", true);
        boolean wakacje = sp.getBoolean("pref_wakacje", false);

        tv.setText("cz: " + fontSize + ", op: " + opis + ", wakacje: " + wakacje);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_glowne,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent i = new Intent (this, Preference.class);
            startActivity(i);

            return true;
        }
       return super.onOptionsItemSelected(item);
    }
}
