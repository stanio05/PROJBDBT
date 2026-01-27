package com.example.bdbt_projekt;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {
    private final JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list() {
        String sql = "SELECT * FROM \"ADRESY\" ORDER BY \"Id_adresu\"";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
    }

    public void save(Adresy adres) {
        String sql =
                "INSERT INTO \"ADRESY\" (\"Miejscowosc\", \"Ulica\", \"Nr_budynku\", \"Nr_lokalu\", \"Kod_pocztowy\") " +
                        "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                adres.getMiejscowosc(),
                adres.getUlica(),
                adres.getNr_budynku(),
                adres.getNr_lokalu(),
                adres.getKod_pocztowy()
        );
    }

    public Adresy get(int idAdresu) {
        String sql = "SELECT * FROM \"ADRESY\" WHERE \"Id_adresu\" = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adresy.class), idAdresu);
    }

    public void delete(int idAdresu) {
        String sql = "DELETE FROM \"ADRESY\" WHERE \"Id_adresu\" = ?";
        jdbcTemplate.update(sql, idAdresu);
    }
}