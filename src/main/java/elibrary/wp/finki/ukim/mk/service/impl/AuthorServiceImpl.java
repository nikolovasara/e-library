package elibrary.wp.finki.ukim.mk.service.impl;

import elibrary.wp.finki.ukim.mk.model.Author;
import elibrary.wp.finki.ukim.mk.model.Book;
import elibrary.wp.finki.ukim.mk.model.Country;
import elibrary.wp.finki.ukim.mk.model.dto.AuthorDto;
import elibrary.wp.finki.ukim.mk.model.enumerations.BookCategory;
import elibrary.wp.finki.ukim.mk.repository.AuthorRepository;
import elibrary.wp.finki.ukim.mk.repository.CountryRepository;
import elibrary.wp.finki.ukim.mk.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country=this.countryRepository.findById(countryId).orElseThrow(()->new RuntimeException("Country not found"));
        Author author=new Author(name,surname,country);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country=this.countryRepository.findById(authorDto.getCountry()).orElseThrow(()->new RuntimeException("Country not found"));
        Author author=new Author(authorDto.getName(),authorDto.getSurname(),country);
        this.authorRepository.save(author);

        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Author author=this.authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));

        author.setName(name);
        author.setSurname(surname);

        Country country=this.countryRepository.findById(countryId).orElseThrow(()->new RuntimeException("Country not found"));
        author.setCountry(country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author=this.authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not found"));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());

        Country country=this.countryRepository.findById(authorDto.getCountry()).orElseThrow(()->new RuntimeException("Country not found"));
        author.setCountry(country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
