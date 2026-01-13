package com.example.bdbt_projekt;
import java.util.Date;

public class Utwory {
    private int Id_utworu;
    private  String Tytul_utworu;
    private Date Czas_trwania;

    public Utwory(int id_utworu, String tytul_utworu, Date czas_trwania) {
        Id_utworu = id_utworu;
        Tytul_utworu = tytul_utworu;
        Czas_trwania = czas_trwania;
    }

    public Utwory() {
        super();
    }

    public int getId_utworu() {
        return Id_utworu;
    }

    public String getTytul_utworu() {
        return Tytul_utworu;
    }

    public Date getCzas_trwania() {
        return Czas_trwania;
    }
    
    public void setId_utworu(int id_utworu) { Id_utworu = id_utworu; }

    public void setTytul_utworu(String tytul_utworu) { Tytul_utworu = tytul_utworu; }

    public void setCzas_trwania(Date czas_trwania) {
        Czas_trwania = czas_trwania;
    }

    @Override
    public String toString() {
        return "Utwory{" +
                "Id_utworu=" + Id_utworu +
                ", Tytul_utworu='" + Tytul_utworu + '\'' +
                ", Czas_trwania=" + Czas_trwania +
                '}';
    }
}
