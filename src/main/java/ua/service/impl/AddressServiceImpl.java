package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.Address;
import ua.exceptions.DataNotFoundException;
import ua.repository.AddressRepository;
import ua.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addOne(Address address, Long regionId) {
        return addressRepository.insert(address, regionId);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getOne(Long id) {
        return Optional.ofNullable(addressRepository.getOne(id))
                .orElseThrow(() -> new DataNotFoundException("Cannot find address with id " + id));
    }

    @Override
    public Address update(Long o, Address o2) {
        return null;
    }

    @Override
    public void delete(Long o) {
    }
}
