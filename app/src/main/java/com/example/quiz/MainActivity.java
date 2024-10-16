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
    private Button buttonNie;


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

        buttonNie=findViewById(R.id.button8);
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzToPytanie(false);
                    }
                }
        );

        buttonNastepne = findViewById(R.id.button10);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnePytanie++;
                        if(aktualnePytanie==listaPytan.size()){
                            buttonNastepne.setVisibility(View.INVISIBLE);
                            buttonTak.setVisibility(View.INVISIBLE);
                            buttonNie.setVisibility(View.INVISIBLE);
                            int ile=podliczPunkty();
                            textView.setText("Zakonczyles test twoja ilosc punktow wynosi: "+String.valueOf(ile));
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
        }else{
            listaPytan.get(aktualnePytanie).setUdzielonoPoprawnaOdpowiedz(false);
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

    private int podliczPunkty(){
        int ilePunktow=0;
        for (Pytanie pytanie:listaPytan ){
            if(pytanie.isUdzielonoPoprawnaOdpowiedz()){
                ilePunktow++;
            }
        }
        return ilePunktow;
    }

}