package com.example.quiz;

public class Pytanie {
    private String pytanie;
    private String podpowiedz;
    private boolean poprawna;
    private boolean udzielonoPoprawnaOdpowiedz;

    public Pytanie(String pytanie, String podpowiedz, boolean poprawna) {
        this.pytanie = pytanie;
        this.podpowiedz = podpowiedz;
        this.poprawna = poprawna;
        udzielonoPoprawnaOdpowiedz=false;
    }

    public String getPytanie() {
        return pytanie;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public boolean isPoprawna() {
        return poprawna;
    }

    public boolean isUdzielonoPoprawnaOdpowiedz() {
        return udzielonoPoprawnaOdpowiedz;
    }

    public void setUdzielonoPoprawnaOdpowiedz(boolean udzielonoPoprawnaOdpowiedz) {
        this.udzielonoPoprawnaOdpowiedz = udzielonoPoprawnaOdpowiedz;
    }
}
