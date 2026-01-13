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

    public List<Radiostacje> list(){
        String sql = "SELECT * FROM RADIOSTACJE";
        List<Radiostacje> listRadiostacje = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Radiostacje.class));
        return listRadiostacje;
    }
    public void save(Radiostacje radiostacje) {

    }
    public Radiostacje get(int Id_stacji){
        return null;
    }
    public void update(Radiostacje radiostacje){

    }
    public void delete(int Id_stacji){

    }
}
