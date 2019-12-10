package ua.service;

import ua.domain.Region;
import ua.service.basic.BasicService;

import java.util.List;

public interface RegionService extends BasicService<Long, Region> {
    List<Region> findAllByID(Long countryId);
}
