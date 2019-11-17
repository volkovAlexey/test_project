package ua.service;

import ua.domain.Address;
import ua.service.basic.BasicService;

public interface AddressService extends BasicService {
    Address addOne(Address address);
}
