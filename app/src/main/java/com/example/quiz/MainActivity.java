package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie>listaPytan = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void wypelnijPytania(){
        listaPytan.add(new Pytanie("Czy sekwoja moze miec 100m wysokosci", "Sekwoje sa bardzo wysokie", true));
        listaPytan.add(new Pytanie("Czy najgrubsze drzewo ma obwod 10m", "Obwod najgrubszego drzewa swiata ma 44 metry", false));
        listaPytan.add(new Pytanie("Czy drzewa sa pochlaniaczem tlenu", "Na czym polega fotosynteza", false));
    }
}