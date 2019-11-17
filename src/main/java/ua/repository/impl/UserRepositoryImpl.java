package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.domain.User;
import ua.repository.basic.AbstractRepository;
import ua.repository.UserRepository;

import java.sql.PreparedStatement;

@Repository
public class UserRepositoryImpl extends AbstractRepository implements UserRepository {

    private static final BeanPropertyRowMapper<User> ROW_MAPPER =
            new BeanPropertyRowMapper<>(User.class);

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public User insert(User user, Long addressId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO users (user_name, password, email, address_id)" +
                            " VALUES (?, ?, ?, ?)", new String[]{"id"});
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setLong(4, addressId);
            return ps;
        }, keyHolder);
        long userId = keyHolder.getKey().longValue();
        return getUser(userId);
    }

    @Override
    public User getUser(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public User update(Long id, User user) {
        jdbcTemplate.update("UPDATE users SET name = ?, password = ?, email = ? WHERE id = ?",
                user.getName(), user.getPassword(), user.getEmail(), id);
        return getUser(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }
}
