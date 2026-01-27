package com.example.bdbt_projekt;

public class Radiostacje {
    private int Id_stacji;
    private String Nazwa;
    private int Id_adresu;

    // Pole pomocnicze (z JOIN) – nie jest kolumną w RADIOSTACJE
    private String Adres_full;

    public Radiostacje() {
        super();
    }

    public Radiostacje(int id_stacji, String nazwa, int id_adresu) {
        Id_stacji = id_stacji;
        Nazwa = nazwa;
        Id_adresu = id_adresu;
    }

    public int getId_stacji() { return Id_stacji; }
    public void setId_stacji(int id_stacji) { Id_stacji = id_stacji; }

    public String getNazwa() { return Nazwa; }
    public void setNazwa(String nazwa) { Nazwa = nazwa; }

    public int getId_adresu() { return Id_adresu; }
    public void setId_adresu(int id_adresu) { Id_adresu = id_adresu; }

    public String getAdres_full() { return Adres_full; }
    public void setAdres_full(String adres_full) { Adres_full = adres_full; }

    @Override
    public String toString() {
        return "Radiostacje{" +
                "Id_stacji=" + Id_stacji +
                ", Nazwa='" + Nazwa + '\'' +
                ", Id_adresu=" + Id_adresu +
                ", Adres_full='" + Adres_full + '\'' +
                '}';
    }
}