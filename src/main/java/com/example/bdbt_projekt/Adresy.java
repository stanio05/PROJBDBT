package com.example.bdbt_projekt;

public class Adresy {
    private int Id_adresu;
    private String Miejscowosc;
    private String Ulica;
    private int Nr_budynku;
    private Integer Nr_lokalu; // może być null
    private String Kod_pocztowy;

    public Adresy() {
        super();
    }

    public int getId_adresu() { return Id_adresu; }
    public void setId_adresu(int id_adresu) { Id_adresu = id_adresu; }

    public String getMiejscowosc() { return Miejscowosc; }
    public void setMiejscowosc(String miejscowosc) { Miejscowosc = miejscowosc; }

    public String getUlica() { return Ulica; }
    public void setUlica(String ulica) { Ulica = ulica; }

    public int getNr_budynku() { return Nr_budynku; }
    public void setNr_budynku(int nr_budynku) { Nr_budynku = nr_budynku; }

    public Integer getNr_lokalu() { return Nr_lokalu; }
    public void setNr_lokalu(Integer nr_lokalu) { Nr_lokalu = nr_lokalu; }

    public String getKod_pocztowy() { return Kod_pocztowy; }
    public void setKod_pocztowy(String kod_pocztowy) { Kod_pocztowy = kod_pocztowy; }
}