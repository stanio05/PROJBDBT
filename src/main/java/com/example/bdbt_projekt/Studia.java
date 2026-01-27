package com.example.bdbt_projekt;

public class Studia {
    private int Id_studia;
    private String Numer_pokoju;
    private String Nazwa; // nullable
    private int Id_stacji;

    public Studia() { }

    public int getId_studia() { return Id_studia; }
    public void setId_studia(int id_studia) { Id_studia = id_studia; }

    public String getNumer_pokoju() { return Numer_pokoju; }
    public void setNumer_pokoju(String numer_pokoju) { Numer_pokoju = numer_pokoju; }

    public String getNazwa() { return Nazwa; }
    public void setNazwa(String nazwa) { Nazwa = nazwa; }

    public int getId_stacji() { return Id_stacji; }
    public void setId_stacji(int id_stacji) { Id_stacji = id_stacji; }
}