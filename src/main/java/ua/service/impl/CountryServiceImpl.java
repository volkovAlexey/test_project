package ua.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.domain.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getOne(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public Country update(Long id, Country country) {
        return countryRepository.update(id, country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(id);
    }
}
