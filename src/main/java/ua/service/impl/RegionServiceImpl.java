package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.Region;
import ua.repository.RegionRepository;
import ua.service.RegionService;

import java.util.List;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> findAllByID(Long countryId) {
        return regionRepository.findAllByID(countryId);
    }

    @Override
    public Region getOne(Long id) {
        return regionRepository.getOne(id);
    }

    @Override
    public Region update(Long countryId, Region region) {
        return regionRepository.update(countryId, region);
    }

    @Override
    public void delete(Long id) {
        regionRepository.delete(id);
    }
}
