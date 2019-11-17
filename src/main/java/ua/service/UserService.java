package ua.service;

import ua.domain.User;
import ua.service.basic.BasicService;

public interface UserService extends BasicService<Long, User> {
    User addUser(User user, Long addressId);
}
