package elibrary.wp.finki.ukim.mk.web.rest;

import elibrary.wp.finki.ukim.mk.model.Author;
import elibrary.wp.finki.ukim.mk.model.Book;
import elibrary.wp.finki.ukim.mk.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<Author> findAll() {
        return this.authorService.findAll();
    }
}
