package com.example.arek.testowaniemetodypost;

/**
 * Created by arek on 26.05.2017.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;


public class InnyWatek extends AsyncTask<Void, Void, String> {
    ProgressDialog pr;
    private String url;
    private HashMap<String, String> postParametry;
    private Context actv;
    //private String wynik;

    public InnyWatek(Context actv, String url, HashMap<String, String> postDataParams){
        this.url=url;
        postParametry=new HashMap<String, String>();
        this.actv = actv;
    }

    protected String doInBackground(Void... voids){
        String wynik="ehh";

        wynik = performPostCall(url,postParametry);
        return wynik;
    }



    @Override

    protected void onPreExecute() {
       // actv.showDialog(MainActivity.PLEASE_WAIT_DIALOG);
      //  pr.show(actv,"PLEASE WAIT","LOADING JOBS...", true);

        pr = new ProgressDialog(actv);
        pr.setTitle("Zaczekaj");
        pr.setMessage("Pobieram dane z serwera");
        pr.setCancelable(false);
        pr.show();

    }

    @Override
    protected void onPostExecute(String wynik) {
        pr.dismiss();
    }

    public String performPostCall(String requestURL,
                                   HashMap<String, String> postDataParams) {
        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
