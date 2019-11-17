package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.User;
import ua.exceptions.DataNotFoundException;
import ua.repository.AddressRepository;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
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
        return Optional.ofNullable(userRepository.getUser(id))
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
}
