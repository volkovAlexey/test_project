package ua.repository;

import ua.domain.Address;
import ua.repository.basic.BasicRepository;

import java.util.List;

public interface AddressRepository extends BasicRepository<Long, Address> {

    List<Address> findAll();

    Address insert(Address address, Long regionId);
}
