package com.example.bdbt_projekt;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmisjeDAO {
    private final JdbcTemplate jdbcTemplate;

    public EmisjeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(int idAudycji, int idUtworu) {
        String sql = "INSERT INTO \"EMISJE\" (\"Id_audycji\", \"Id_utworu\") VALUES (?, ?)";
        jdbcTemplate.update(sql, idAudycji, idUtworu);
    }

    public void delete(int idAudycji, int idUtworu) {
        String sql = "DELETE FROM \"EMISJE\" WHERE \"Id_audycji\" = ? AND \"Id_utworu\" = ?";
        jdbcTemplate.update(sql, idAudycji, idUtworu);
    }

    public List<UtworInAudycjaView> listUtworyForAudycja(int idAudycji) {
        String sql =
                "SELECT u.\"Id_utworu\" AS id_utworu, u.\"Tytul\" AS tytul " +
                        "FROM \"EMISJE\" e " +
                        "JOIN \"UTWORY\" u ON u.\"Id_utworu\" = e.\"Id_utworu\" " +
                        "WHERE e.\"Id_audycji\" = ? " +
                        "ORDER BY u.\"Tytul\"";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UtworInAudycjaView.class), idAudycji);
    }
}