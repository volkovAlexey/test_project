package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.Address;
import ua.repository.AddressRepository;
import ua.service.AddressService;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addOne(Address address) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getOne(Object o) {
        return null;
    }

    @Override
    public Object update(Object o, Object o2) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }
}
