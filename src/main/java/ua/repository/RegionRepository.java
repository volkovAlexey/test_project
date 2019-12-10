package ua.repository;

import ua.domain.Region;
import ua.repository.basic.BasicRepository;

import java.util.List;

public interface RegionRepository extends BasicRepository<Long, Region> {
    List<Region> findAll();

    List<Region> findAllByID(Long countryId);
}
