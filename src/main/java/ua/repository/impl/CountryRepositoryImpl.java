package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.domain.Country;
import ua.repository.CountryRepository;
import ua.repository.basic.AbstractRepository;

import java.util.List;

@Repository
public class CountryRepositoryImpl extends AbstractRepository implements CountryRepository {

    private static final BeanPropertyRowMapper<Country> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Country.class);

    @Autowired
    public CountryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }


    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query("SELECT * FROM countries", ROW_MAPPER);
    }

    @Override
    public Country getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM countries WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM countries WHERE id = ?", id);
    }

    @Override
    public Country update(Long id, Country country) {
        jdbcTemplate.update("UPDATE countries SET name = ? WHERE id = ?",
                country.getName(), id);
        return getOne(country.getId());
    }
}
