package com.example.bdbt_projekt;

import java.util.Date;

public class Audycje {
    private int Id_audycji;
    private  String Tytul_audycji;
    private String Kategoria;
    private Date Data_emisji;
    private String Opis;
    private int Id_studia;

    public Audycje(int id_audycji, String tytul_audycji, String kategoria, Date data_emisji, String opis, int id_studia) {
        Id_audycji = id_audycji;
        Tytul_audycji = tytul_audycji;
        Kategoria = kategoria;
        Data_emisji = data_emisji;
        Opis = opis;
        Id_studia = id_studia;
    }

    public Audycje() {
        super();
    }

    public int getId_audycji() {
        return Id_audycji;
    }

    public String getTytul_audycji() {
        return Tytul_audycji;
    }

    public String getKategoria() {
        return Kategoria;
    }

    public Date getData_emisji() {
        return Data_emisji;
    }

    public String getOpis() {
        return Opis;
    }

    public int getId_studia() {
        return Id_studia;
    }

    public void setId_audycji(int id_audycji) {
        Id_audycji = id_audycji;
    }

    public void setTytul_audycji(String tytul_audycji) {
        Tytul_audycji = tytul_audycji;
    }

    public void setKategoria(String kategoria) {
        Kategoria = kategoria;
    }

    public void setData_emisji(Date data_emisji) {
        Data_emisji = data_emisji;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public void setId_studia(int id_studia) {
        Id_studia = id_studia;
    }

    @Override
    public String toString() {
        return "Audycje{" +
                "Id_audycji=" + Id_audycji +
                ", Tytul_audycji='" + Tytul_audycji + '\'' +
                ", Kategoria='" + Kategoria + '\'' +
                ", Data_emisji=" + Data_emisji +
                ", Opis='" + Opis + '\'' +
                ", Id_studia=" + Id_studia +
                '}';
    }
}
