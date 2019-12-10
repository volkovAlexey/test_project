package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.domain.Region;
import ua.repository.RegionRepository;
import ua.repository.basic.AbstractRepository;

import java.util.List;

@Repository
public class RegionRepositoryImpl extends AbstractRepository implements RegionRepository {

    private static final BeanPropertyRowMapper<Region> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Region.class);

    @Autowired
    public RegionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Region> findAll() {
        return jdbcTemplate.query("SELECT * FROM regions", ROW_MAPPER);
    }

    @Override
    public List<Region> findAllByID(Long countryId) {
        return jdbcTemplate.query("SELECT * FROM regions WHERE country_id = ?", ROW_MAPPER, countryId);
    }

    @Override
    public Region getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM regions WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM regions WHERE id = ?", id);
    }

    @Override
    public Region update(Long countryId, Region region) {
        jdbcTemplate.update("UPDATE regions SET name = ?, country_id = ? WHERE id = ?",
                region.getName(), countryId, region.getId());
        return getOne(region.getId());
    }
}
