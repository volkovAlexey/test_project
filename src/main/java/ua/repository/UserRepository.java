package ua.repository;

import ua.domain.User;
import ua.repository.basic.BasicRepository;

public interface UserRepository extends BasicRepository<Long, User> {
    User insert(User user, Long addressId);

    User getUserByNameAndPassword(String name, String password);

    User getUserByName(String name);

    User getUserByEmail(String email);
}
