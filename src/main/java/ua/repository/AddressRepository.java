package ua.repository;

import ua.domain.Address;
import ua.repository.basic.BasicRepository;

public interface AddressRepository extends BasicRepository<Long, Address> {
    Address addOne(Address address);
}
