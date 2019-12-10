package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.domain.Address;
import ua.repository.AddressRepository;
import ua.repository.basic.AbstractRepository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AddressRepositoryImpl extends AbstractRepository implements AddressRepository {

    private static final BeanPropertyRowMapper<Address> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Address.class);

    @Autowired
    public AddressRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Address> findAll() {
        return jdbcTemplate.query("SELECT * FROM addresses", ROW_MAPPER);
    }

    @Override
    public Address insert(Address address, Long regionId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO addresses (city, region_id)" +
                            " VALUES (?, ?)", new String[]{"id"});
            ps.setString(1, address.getCity());
            ps.setLong(2, regionId);
            return ps;
        }, keyHolder);
        long id = keyHolder.getKey().longValue();
        return getOne(id);
    }

    @Override
    public Address getOne(Long id) {
        List<Address> result = jdbcTemplate.query(
                "SELECT * FROM addresses WHERE id = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(result);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM addresses WHERE id = ?", id);
    }

    @Override
    public Address update(Long regionId, Address address) {
        jdbcTemplate.update("UPDATE addresses SET city = ?, region_id = ? WHERE id = ?",
                address.getCity(), regionId, address.getId());
        return getOne(address.getId());
    }
}
