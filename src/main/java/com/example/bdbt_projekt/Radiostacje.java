package com.example.bdbt_projekt;
import java.util.Date;

public class Radiostacje {
    private int Id_stacji;
    private  String Nazwa;
    private String Adres;

    public Radiostacje(int id_stacji, String nazwa, String adres) {
        Id_stacji = id_stacji;
        Nazwa = nazwa;
        Adres = adres;
    }

    public Radiostacje() {
        super();
    }

    public int getId_stacji() {
        return Id_stacji;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public String getAdres() {
        return Adres;
    }

    public void setId_stacji(int id_stacji) { Id_stacji = id_stacji; }

    public void setNazwa(String nazwa) { Nazwa = nazwa; }

    public void setAdres(String adres) {
        Adres = adres;
    }

    @Override
    public String toString() {
        return "Radiostacje{" +
                "Id_stacji=" + Id_stacji +
                ", Nazwa='" + Nazwa + '\'' +
                ", Adres=" + Adres +
                '}';
    }
}