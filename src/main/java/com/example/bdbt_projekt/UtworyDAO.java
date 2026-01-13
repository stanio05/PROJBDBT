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

    public List<Utwory> list(){
        String sql = "SELECT * FROM UTWORY";
        List<Utwory> listUtwory = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Utwory.class));
        return listUtwory;
    }
    public void save(Utwory utwory) {

    }
    public Utwory get(int Id_utworu){
        return null;
    }
    public void update(Utwory utwory){

    }
    public void delete(int Id_utworu){

    }
}
