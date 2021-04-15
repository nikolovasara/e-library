package elibrary.wp.finki.ukim.mk.service;

import elibrary.wp.finki.ukim.mk.model.Author;
import elibrary.wp.finki.ukim.mk.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name, String surname, Long country);

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, String name, String surname, Long country);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}
