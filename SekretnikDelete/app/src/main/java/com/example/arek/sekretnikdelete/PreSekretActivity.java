package com.example.arek.sekretnikdelete;

        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class PreSekretActivity extends AppCompatActivity {

    static final String HASLO = "com.example.betany.Kzadanie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_sekret);
    }

    public void sprawdzHaslo(View view){

        SharedPreferences sharedPref = getSharedPreferences("DANE", Context.MODE_PRIVATE);
        String hasloWlasciwe = sharedPref.getString(HASLO, "Nieznane");
        String hasloPodane = ((EditText)findViewById(R.id.hasloText)).getText().toString();

        if(hasloWlasciwe.equals("Nieznane")){
            new AlertDialog.Builder(this)
                    .setTitle("Haslo nie zostalo jak dotad zdefiniowane")
                    .setMessage("Zdefiniuj je w ustawieniach")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else if(hasloWlasciwe.equals(hasloPodane)){
            Intent sekretActv = new Intent(this,SekretActivity.class);
            startActivity(sekretActv);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Wprowadziles bledne haslo")
                    .setMessage("Wprowadz poprawne haslo")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ((TextView)findViewById(R.id.hasloText)).setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

}
