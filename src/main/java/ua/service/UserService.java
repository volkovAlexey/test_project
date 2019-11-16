package ua.service;

import ua.domain.User;

public interface UserService {
    User addUser(User user);

    User getUser(Long id);

    void delete(Long id);

    User update(Long id, User user);
}
