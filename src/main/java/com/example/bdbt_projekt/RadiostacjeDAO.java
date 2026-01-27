package com.example.bdbt_projekt;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RadiostacjeDAO {
    private final JdbcTemplate jdbcTemplate;

    public RadiostacjeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // LISTA z pełnym adresem (JOIN)
    public List<Radiostacje> list() {
        String sql =
                "SELECT r.\"Id_stacji\", r.\"Nazwa\", r.\"Id_adresu\", " +
                        "       (a.\"Miejscowosc\" || ', ' || a.\"Ulica\" || ' ' || a.\"Nr_budynku\" || " +
                        "        CASE WHEN a.\"Nr_lokalu\" IS NULL THEN '' ELSE '/' || a.\"Nr_lokalu\" END || " +
                        "        ', ' || a.\"Kod_pocztowy\") AS adres_full " +
                        "FROM \"RADIOSTACJE\" r " +
                        "JOIN \"ADRESY\" a ON a.\"Id_adresu\" = r.\"Id_adresu\" " +
                        "ORDER BY r.\"Nazwa\"";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Radiostacje.class));
    }

    public Radiostacje get(int Id_stacji) {
        String sql =
                "SELECT r.\"Id_stacji\", r.\"Nazwa\", r.\"Id_adresu\", " +
                        "       (a.\"Miejscowosc\" || ', ' || a.\"Ulica\" || ' ' || a.\"Nr_budynku\" || " +
                        "        CASE WHEN a.\"Nr_lokalu\" IS NULL THEN '' ELSE '/' || a.\"Nr_lokalu\" END || " +
                        "        ', ' || a.\"Kod_pocztowy\") AS adres_full " +
                        "FROM \"RADIOSTACJE\" r " +
                        "JOIN \"ADRESY\" a ON a.\"Id_adresu\" = r.\"Id_adresu\" " +
                        "WHERE r.\"Id_stacji\" = ?";

        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Radiostacje.class), Id_stacji);
    }

    public void save(Radiostacje radiostacje) {
        String sql = "INSERT INTO \"RADIOSTACJE\" (\"Nazwa\", \"Id_adresu\") VALUES (?, ?)";
        jdbcTemplate.update(sql, radiostacje.getNazwa(), radiostacje.getId_adresu());
    }

    public void update(Radiostacje radiostacje) {
        String sql = "UPDATE \"RADIOSTACJE\" SET \"Nazwa\" = ?, \"Id_adresu\" = ? WHERE \"Id_stacji\" = ?";
        jdbcTemplate.update(sql, radiostacje.getNazwa(), radiostacje.getId_adresu(), radiostacje.getId_stacji());
    }

    public void delete(int Id_stacji) {
        String sql = "DELETE FROM \"RADIOSTACJE\" WHERE \"Id_stacji\" = ?";
        jdbcTemplate.update(sql, Id_stacji);
    }
}