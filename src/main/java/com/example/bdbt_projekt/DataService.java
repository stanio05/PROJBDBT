package com.example.bdbt_projekt;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final AudycjeDAO audycjeDAO;
    private final RadiostacjeDAO radiostacjeDAO;
    private final AdresyDAO adresyDAO;
    private final StudiaDAO studiaDAO;
    private final UtworyDAO utworyDAO;
    private final EmisjeDAO emisjeDAO;
    public DataService(AudycjeDAO audycjeDAO, RadiostacjeDAO radiostacjeDAO, AdresyDAO adresyDAO,StudiaDAO studiaDAO, UtworyDAO utworyDAO,EmisjeDAO emisjeDAO) {
        this.audycjeDAO = audycjeDAO;
        this.radiostacjeDAO = radiostacjeDAO;
        this.adresyDAO = adresyDAO;
        this.studiaDAO = studiaDAO;
        this.utworyDAO = utworyDAO;
        this.emisjeDAO = emisjeDAO;
    }

    // =========================
    // AUDYCJE
    // =========================
    public List<Audycje> getAudycje() {
        return audycjeDAO.list();
    }

    public void addAudycja(Audycje audycje) {
        audycjeDAO.save(audycje);
    }

    public Audycje getAudycja(int idAudycji) {
        return audycjeDAO.get(idAudycji);
    }

    public void updateAudycja(Audycje audycje) {
        audycjeDAO.update(audycje);
    }

    public void deleteAudycja(int idAudycji) {
        audycjeDAO.delete(idAudycji);
    }

    // =========================
    // ADRESY
    // =========================
    public List<Adresy> getAdresy() {
        return adresyDAO.list();
    }

    public void addAdres(Adresy adres) {
        adresyDAO.save(adres);
    }

    public Adresy getAdres(int idAdresu) {
        return adresyDAO.get(idAdresu);
    }

    public void deleteAdres(int idAdresu) {
        adresyDAO.delete(idAdresu);
    }

    // =========================
    // RADIOSTACJE
    // =========================
    public List<Radiostacje> getRadiostacje() {
        return radiostacjeDAO.list(); // u Ciebie: JOIN -> daje Adres_full
    }

    public void addRadiostacja(Radiostacje r) {
        radiostacjeDAO.save(r);
    }

    public Radiostacje getRadiostacja(int idStacji) {
        return radiostacjeDAO.get(idStacji); // też JOIN -> ma Adres_full
    }

    public void updateRadiostacja(Radiostacje r) {
        radiostacjeDAO.update(r);
    }

    public void deleteRadiostacja(int idStacji) {
        radiostacjeDAO.delete(idStacji);
    }
    public List<Studia> getStudia() {
        return studiaDAO.list();
    }

    public List<StudiaView> getStudiaView() {
        return studiaDAO.listView();
    }

    public void addStudio(Studia s) {
        studiaDAO.save(s);
    }

    public Studia getStudio(int idStudia) {
        return studiaDAO.get(idStudia);
    }

    public void updateStudio(Studia s) {
        studiaDAO.update(s);
    }

    public void deleteStudio(int idStudia) {
        studiaDAO.delete(idStudia);
    }
    public List<AudycjeView> getAudycjeView() {
        return audycjeDAO.listView();
    }
    public List<Utwory> getUtwory() {
        return utworyDAO.list();
    }

    public void addUtwor(Utwory u) {
        utworyDAO.save(u);
    }

    public Utwory getUtwor(int idUtworu) {
        return utworyDAO.get(idUtworu);
    }

    public void updateUtwor(Utwory u) {
        utworyDAO.update(u);
    }

    public void deleteUtwor(int idUtworu) {
        utworyDAO.delete(idUtworu);
    }
    public void addEmisja(int idAudycji, int idUtworu) {
        emisjeDAO.add(idAudycji, idUtworu);
    }

    public void deleteEmisja(int idAudycji, int idUtworu) {
        emisjeDAO.delete(idAudycji, idUtworu);
    }

    public List<UtworInAudycjaView> getUtworyForAudycja(int idAudycji) {
        return emisjeDAO.listUtworyForAudycja(idAudycji);
    }
    public java.util.List<Audycje> getAudycjeForRadiostacja(int idStacji) {
        return audycjeDAO.listForRadiostacja(idStacji);
    }
}