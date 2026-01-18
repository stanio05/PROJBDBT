package com.example.bdbt_projekt;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AudycjeDAO {
    private final JdbcTemplate jdbcTemplate;

    public AudycjeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Audycje> list(){
        String sql = "SELECT * FROM AUDYCJE";
        List<Audycje> listAudycje = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Audycje.class));
        return listAudycje;
    }
    public void save(Audycje audycje) {
        String sql =
                "INSERT INTO \"AUDYCJE\" (\"Tytul_audycji\", \"Opis\", \"Kategoria\", \"Data_emisji\", \"Id_studia\") " + "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                audycje.getTytul_audycji(),
                audycje.getOpis(),
                audycje.getKategoria(),
                audycje.getData_emisji(),
                audycje.getId_studia()

        );
    }

    public Audycje get(int idAudycji) {
        String sql = "SELECT * FROM AUDYCJE WHERE id_audycji = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Audycje.class), idAudycji);
    }

    public void update(Audycje audycje) {
        String sql = "UPDATE AUDYCJE SET tytul_audycji = ?, opis = ?, kategoria = ? WHERE id_audycji = ?";
        jdbcTemplate.update(sql, audycje.getTytul_audycji(), audycje.getOpis(), audycje.getKategoria(), audycje.getId_audycji());
    }

    public void delete(int idAudycji) {
        String sql = "DELETE FROM AUDYCJE WHERE id_audycji = ?";
        jdbcTemplate.update(sql, idAudycji);
    }
}
