package ua.repository;

import ua.domain.Country;
import ua.repository.basic.BasicRepository;

import java.util.List;

public interface CountryRepository extends BasicRepository<Long, Country> {
    List<Country> findAll();
}
