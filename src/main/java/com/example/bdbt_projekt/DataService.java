package com.example.bdbt_projekt;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final AudycjeDAO audycjeDAO;
    private final RadiostacjeDAO radiostacjeDAO;

    public DataService(AudycjeDAO audycjeDAO, RadiostacjeDAO radiostacjeDAO) {
        this.audycjeDAO = audycjeDAO;
        this.radiostacjeDAO = radiostacjeDAO;
    }

    public List<Audycje> getAudycje() {
        return audycjeDAO.list();
    }

    public List<Radiostacje> getRadiostacje() {
        return radiostacjeDAO.list();
    }
    public void addAudycja(Audycje audycje) {
        audycjeDAO.save(audycje);
    }
}