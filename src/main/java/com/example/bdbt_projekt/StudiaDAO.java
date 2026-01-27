package com.example.bdbt_projekt;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudiaDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudiaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // lista do dropdownów (bez joinów)
    public List<Studia> list() {
        String sql = "SELECT * FROM \"STUDIA\" ORDER BY \"Id_studia\"";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Studia.class));
    }

    // lista do admin table (z nazwą radiostacji)
    public List<StudiaView> listView() {
        String sql =
                "SELECT s.\"Id_studia\" AS id_studia, " +
                        "       s.\"Numer_pokoju\" AS numer_pokoju, " +
                        "       s.\"Nazwa\" AS nazwa, " +
                        "       s.\"Id_stacji\" AS id_stacji, " +
                        "       r.\"Nazwa\" AS nazwa_radiostacji " +
                        "FROM \"STUDIA\" s " +
                        "JOIN \"RADIOSTACJE\" r ON r.\"Id_stacji\" = s.\"Id_stacji\" " +
                        "ORDER BY s.\"Id_studia\"";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(StudiaView.class));
    }

    public Studia get(int idStudia) {
        String sql = "SELECT * FROM \"STUDIA\" WHERE \"Id_studia\" = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Studia.class), idStudia);
    }

    public void save(Studia s) {
        String sql =
                "INSERT INTO \"STUDIA\" (\"Numer_pokoju\", \"Nazwa\", \"Id_stacji\") " +
                        "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, s.getNumer_pokoju(), s.getNazwa(), s.getId_stacji());
    }

    public void update(Studia s) {
        String sql =
                "UPDATE \"STUDIA\" SET \"Numer_pokoju\" = ?, \"Nazwa\" = ?, \"Id_stacji\" = ? " +
                        "WHERE \"Id_studia\" = ?";
        jdbcTemplate.update(sql, s.getNumer_pokoju(), s.getNazwa(), s.getId_stacji(), s.getId_studia());
    }

    public void delete(int idStudia) {
        String sql = "DELETE FROM \"STUDIA\" WHERE \"Id_studia\" = ?";
        jdbcTemplate.update(sql, idStudia);
    }
}