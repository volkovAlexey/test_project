package ua.repository.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractRepository {

    protected final JdbcTemplate jdbcTemplate;

    @Autowired
    public AbstractRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
