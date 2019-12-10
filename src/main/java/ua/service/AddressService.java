package ua.service;

import ua.domain.Address;
import ua.service.basic.BasicService;

import java.util.List;

public interface AddressService extends BasicService<Long, Address> {
    Address addOne(Address address, Long regionId);
}
