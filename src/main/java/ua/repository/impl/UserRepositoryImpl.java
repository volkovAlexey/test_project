package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.domain.User;
import ua.repository.utils.MD5EncryptionUtil;
import ua.repository.basic.AbstractRepository;
import ua.repository.UserRepository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
            ps.setString(1, user.getUserName());
            ps.setString(2, MD5EncryptionUtil.md5EncryptionCustom(user.getPassword()));
            ps.setString(3, user.getEmail());
            ps.setLong(4, addressId);
            return ps;
        }, keyHolder);
        long userId = keyHolder.getKey().longValue();
        return getOne(userId);
    }

    @Override
    public User getOne(Long id) {
        List<User> userList = jdbcTemplate.query(
                "SELECT * FROM users WHERE id = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(userList);
    }

    @Override
    public User getUserByNameAndPassword(String userName, String password) {
        List<User> userList = jdbcTemplate.query(
                "SELECT * FROM users WHERE user_name = ? AND password = ?",
                ROW_MAPPER, userName, MD5EncryptionUtil.md5EncryptionCustom(password));
        return DataAccessUtils.singleResult(userList);
    }

    @Override
    public User update(Long id, User user) {
        jdbcTemplate.update("UPDATE users SET user_name = ?, password = ?, email = ?, address_id = ? WHERE id = ?",
                user.getUserName(), user.getPassword(), user.getEmail(), id, user.getId());
        return getOne(user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public User getUserByName(String name) {
        List<User> userList = jdbcTemplate.query(
                "SELECT * FROM users WHERE user_name = ?", ROW_MAPPER, name);
        User user = DataAccessUtils.singleResult(userList);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE email = ?",
                ROW_MAPPER, email);
        User user = DataAccessUtils.singleResult(userList);
        return user;
    }
}
