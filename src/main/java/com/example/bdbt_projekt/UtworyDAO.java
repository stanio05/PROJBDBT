package com.example.bdbt_projekt;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtworyDAO {

    private final JdbcTemplate jdbcTemplate;

    public UtworyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Utwory> list() {
        String sql = "SELECT \"Id_utworu\", \"Tytul\", \"Id_albumu\" FROM \"UTWORY\" ORDER BY \"Id_utworu\"";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Utwory.class));
    }

    public Utwory get(int idUtworu) {
        String sql = "SELECT \"Id_utworu\", \"Tytul\", \"Id_albumu\" FROM \"UTWORY\" WHERE \"Id_utworu\" = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Utwory.class), idUtworu);
    }

    public void save(Utwory u) {
        // Czas_trwania jest NOT NULL w DB -> ustawiamy stałą wartość
        String sql =
                "INSERT INTO \"UTWORY\" (\"Tytul\", \"Czas_trwania\", \"Id_albumu\") " +
                        "VALUES (?, TRUNC(SYSDATE), ?)";
        jdbcTemplate.update(sql, u.getTytul(), u.getId_albumu());
    }

    public void update(Utwory u) {
        // Nie ruszamy Czas_trwania w update (zostaje jak jest)
        String sql =
                "UPDATE \"UTWORY\" SET \"Tytul\" = ?, \"Id_albumu\" = ? " +
                        "WHERE \"Id_utworu\" = ?";
        jdbcTemplate.update(sql, u.getTytul(), u.getId_albumu(), u.getId_utworu());
    }

    public void delete(int idUtworu) {
        String sql = "DELETE FROM \"UTWORY\" WHERE \"Id_utworu\" = ?";
        jdbcTemplate.update(sql, idUtworu);
    }
}