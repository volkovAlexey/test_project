package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Address addOne(Address address) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO addresses (country, region, city)" +
                            " VALUES (?, ?, ?)", new String[]{"id"});
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getRegion());
            ps.setString(3, address.getCity());
            return ps;
        }, keyHolder);
        long addressId = keyHolder.getKey().longValue();
        return getOne(addressId);
    }

    @Override
    public Address getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM addresses WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM addresses WHERE id = ?", id);
    }

    @Override
    public Address update(Long id, Address address) {
        jdbcTemplate.update("UPDATE addresses SET country = ?, region = ?, city = ? WHERE id = ?",
                address.getCountry(), address.getRegion(), address.getCity(), id);
        return getOne(id);
    }
}
