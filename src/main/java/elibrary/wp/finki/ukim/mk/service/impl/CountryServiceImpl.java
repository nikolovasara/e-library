package elibrary.wp.finki.ukim.mk.service.impl;

import elibrary.wp.finki.ukim.mk.repository.CountryRepository;
import elibrary.wp.finki.ukim.mk.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}
