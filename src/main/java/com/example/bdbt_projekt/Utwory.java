package com.example.bdbt_projekt;

public class Utwory {
    private int Id_utworu;
    private String Tytul;
    private int Id_albumu;

    public Utwory() { }

    public int getId_utworu() { return Id_utworu; }
    public void setId_utworu(int id_utworu) { Id_utworu = id_utworu; }

    public String getTytul() { return Tytul; }
    public void setTytul(String tytul) { Tytul = tytul; }

    public int getId_albumu() { return Id_albumu; }
    public void setId_albumu(int id_albumu) { Id_albumu = id_albumu; }
}