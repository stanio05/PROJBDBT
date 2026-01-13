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

    }
    public Audycje get(int Id_audcyji){
        return null;
    }
    public void update(Audycje audycje){

    }
    public void delete(int Id_audycji){

    }
}
