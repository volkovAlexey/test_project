package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.User;
import ua.exceptions.DataNotFoundException;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User getUser(Long id) {
        return Optional.ofNullable(userRepository.getUser(id))
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + id));
    }

    @Override
    public void delete(Long id) {
        getUser(id);
        userRepository.delete(id);
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.update(id, user);
    }
}
