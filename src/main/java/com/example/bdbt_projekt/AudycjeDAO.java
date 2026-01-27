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
    public List<AudycjeView> listView() {
        String sql =
                "SELECT a.\"Id_audycji\" AS id_audycji, " +
                        "       a.\"Tytul_audycji\" AS tytul_audycji, " +
                        "       a.\"Kategoria\" AS kategoria, " +
                        "       a.\"Data_emisji\" AS data_emisji, " +
                        "       a.\"Opis\" AS opis, " +
                        "       a.\"Id_studia\" AS id_studia, " +
                        "       s.\"Numer_pokoju\" AS numer_pokoju, " +
                        "       s.\"Nazwa\" AS nazwa_studia, " +
                        "       s.\"Id_stacji\" AS id_stacji, " +
                        "       r.\"Nazwa\" AS nazwa_radiostacji " +
                        "FROM \"AUDYCJE\" a " +
                        "JOIN \"STUDIA\" s ON s.\"Id_studia\" = a.\"Id_studia\" " +
                        "JOIN \"RADIOSTACJE\" r ON r.\"Id_stacji\" = s.\"Id_stacji\" " +
                        "ORDER BY a.\"Id_audycji\"";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AudycjeView.class));
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
        String sql = "SELECT * FROM \"AUDYCJE\" WHERE \"Id_audycji\" = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Audycje.class), idAudycji);
    }

    public void update(Audycje audycje) {
        String sql = "UPDATE \"AUDYCJE\" SET \"Tytul_audycji\"=?, \"Opis\"=?, \"Kategoria\"=?, \"Id_studia\"=?, \"Data_emisji\"=? WHERE \"Id_audycji\"=?";
        jdbcTemplate.update(sql,
                audycje.getTytul_audycji(),
                audycje.getOpis(),
                audycje.getKategoria(),
                audycje.getId_studia(),
                audycje.getData_emisji(),
                audycje.getId_audycji()
        );
    }

    public void delete(int idAudycji) {
        String sql = "DELETE FROM \"AUDYCJE\" WHERE \"Id_audycji\" = ?";
        jdbcTemplate.update(sql, idAudycji);
    }
    public List<Audycje> listForRadiostacja(int idStacji) {
        String sql =
                "SELECT a.\"Id_audycji\" AS id_audycji, " +
                        "       a.\"Tytul_audycji\" AS tytul_audycji, " +
                        "       a.\"Opis\" AS opis, " +
                        "       a.\"Kategoria\" AS kategoria, " +
                        "       a.\"Id_studia\" AS id_studia, " +
                        "       a.\"Data_emisji\" AS data_emisji " +
                        "FROM \"AUDYCJE\" a " +
                        "JOIN \"STUDIA\" s ON s.\"Id_studia\" = a.\"Id_studia\" " +
                        "WHERE s.\"Id_stacji\" = ? " +
                        "ORDER BY a.\"Data_emisji\" DESC, a.\"Id_audycji\" DESC";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Audycje.class), idStacji);
    }

}
