package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie>listaPytan = new ArrayList<>();
    private TextView textView;
    private int aktualnePytanie;
    private Button buttonNastepne;
    private Button buttonTak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wypelnijPytania();

        textView= findViewById(R.id.textViewTrescPytania);
        aktualnePytanie=0;
        wstawPytanie(aktualnePytanie);

        buttonTak=findViewById(R.id.button7);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzToPytanie(true);
                    }
                }
        );

        buttonNastepne = findViewById(R.id.button10);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnePytanie++;
                        wstawPytanie(aktualnePytanie);
                        if(aktualnePytanie==listaPytan.size()){
                            buttonNastepne.setVisibility(View.INVISIBLE);
                        }else{
                            wstawPytanie(aktualnePytanie);
                        }
                    }
                }
        );

    }

    private void sprawdzToPytanie(boolean odpowiedzUzytkownika){
        if(listaPytan.get(aktualnePytanie).isPoprawna()==odpowiedzUzytkownika){
            listaPytan.get(aktualnePytanie).setUdzielonoPoprawnaOdpowiedz(true);
        }
    }

    private void wstawPytanie(int i){
        Pytanie pytanie = listaPytan.get(i);
        textView.setText(pytanie.getPytanie());
    }

    private void wypelnijPytania(){
        listaPytan.add(new Pytanie("Czy sekwoja moze miec 100m wysokosci", "Sekwoje sa bardzo wysokie", true));
        listaPytan.add(new Pytanie("Czy najgrubsze drzewo ma obwod 10m", "Obwod najgrubszego drzewa swiata ma 44 metry", false));
        listaPytan.add(new Pytanie("Czy drzewa sa pochlaniaczem tlenu", "Na czym polega fotosynteza", false));
    }
}