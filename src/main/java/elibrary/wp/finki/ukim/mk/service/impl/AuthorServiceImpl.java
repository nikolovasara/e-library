package elibrary.wp.finki.ukim.mk.service.impl;

import elibrary.wp.finki.ukim.mk.repository.AuthorRepository;
import elibrary.wp.finki.ukim.mk.repository.CountryRepository;
import elibrary.wp.finki.ukim.mk.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }
}
