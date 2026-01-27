package com.example.bdbt_projekt;

import java.util.Date;

public class AudycjeView {
    private int id_audycji;
    private String tytul_audycji;
    private String kategoria;
    private Date data_emisji;
    private String opis;
    private int id_studia;

    private String numer_pokoju;
    private String nazwa_studia;
    private int id_stacji;
    private String nazwa_radiostacji;

    public int getId_audycji() { return id_audycji; }
    public void setId_audycji(int id_audycji) { this.id_audycji = id_audycji; }

    public String getTytul_audycji() { return tytul_audycji; }
    public void setTytul_audycji(String tytul_audycji) { this.tytul_audycji = tytul_audycji; }

    public String getKategoria() { return kategoria; }
    public void setKategoria(String kategoria) { this.kategoria = kategoria; }

    public Date getData_emisji() { return data_emisji; }
    public void setData_emisji(Date data_emisji) { this.data_emisji = data_emisji; }

    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }

    public int getId_studia() { return id_studia; }
    public void setId_studia(int id_studia) { this.id_studia = id_studia; }

    public String getNumer_pokoju() { return numer_pokoju; }
    public void setNumer_pokoju(String numer_pokoju) { this.numer_pokoju = numer_pokoju; }

    public String getNazwa_studia() { return nazwa_studia; }
    public void setNazwa_studia(String nazwa_studia) { this.nazwa_studia = nazwa_studia; }

    public int getId_stacji() { return id_stacji; }
    public void setId_stacji(int id_stacji) { this.id_stacji = id_stacji; }

    public String getNazwa_radiostacji() { return nazwa_radiostacji; }
    public void setNazwa_radiostacji(String nazwa_radiostacji) { this.nazwa_radiostacji = nazwa_radiostacji; }
}