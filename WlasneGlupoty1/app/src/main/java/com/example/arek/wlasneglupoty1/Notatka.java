package com.example.arek.wlasneglupoty1;

/**
 * Created by arek on 19.04.2017.
 */

public class Notatka {

    private int id;
    private String tytul, tresc;

    public Notatka(){

    }

    public Notatka(String tytul, String tresc) {
        this.tytul = tytul;
        this.tresc = tresc;
    }

    public Notatka(int id, String tytul, String tresc) {

        this.id = id;
        this.tytul = tytul;
        this.tresc = tresc;
    }

    public int getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return super.toString();
    }
}
