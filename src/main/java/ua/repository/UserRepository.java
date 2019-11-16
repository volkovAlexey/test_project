package ua.repository;

import ua.domain.User;

public interface UserRepository {
    User insert(User user);

    User getUser(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
