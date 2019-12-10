package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.User;
import ua.exceptions.DataNotFoundException;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User addUser(User user, Long addressId) {
        return userRepository.insert(user, addressId);
    }

    @Override
    public User getOne(Long id) {
        return Optional.ofNullable(userRepository.getOne(id))
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id " + id));
    }

    @Override
    public void delete(Long id) {
        getOne(id);
        userRepository.delete(id);
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.update(id, user);
    }

    @Override
    public User getUserByName(String name) {
        return Optional.ofNullable(userRepository.getUserByName(name))
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with name " + name));
    }

    @Override
    public User getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.getUserByEmail(email))
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with name " + email));
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        return Optional.ofNullable(userRepository.getUserByNameAndPassword(name, password))
                .orElseThrow(() -> new DataNotFoundException("Cannot find user"));
    }
}
