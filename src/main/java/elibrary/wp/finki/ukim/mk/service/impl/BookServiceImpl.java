package elibrary.wp.finki.ukim.mk.service.impl;

import elibrary.wp.finki.ukim.mk.model.Author;
import elibrary.wp.finki.ukim.mk.model.Book;
import elibrary.wp.finki.ukim.mk.model.dto.BookDto;
import elibrary.wp.finki.ukim.mk.model.enumerations.BookCategory;
import elibrary.wp.finki.ukim.mk.repository.AuthorRepository;
import elibrary.wp.finki.ukim.mk.repository.BookRepository;
import elibrary.wp.finki.ukim.mk.service.BookService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> lend(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
        if(book.getAvailableCopies()==0){
            return Optional.of(book);
        }
        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(String name, Integer bookCategory, Long authorId, Integer availableCopies) {
        BookCategory category=BookCategory.values()[bookCategory];
        Author author=this.authorRepository.findById(authorId).orElseThrow(()->new RuntimeException("Author not found"));

        this.bookRepository.deleteByName(name);
        Book book=new Book(name,category,author,availableCopies);
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        BookCategory category=BookCategory.values()[bookDto.getCategory()];
        Author author=this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(()->new RuntimeException("Author not found"));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(),category,author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Integer bookCategory, Long authorId, Integer availableCopies) {
        Book book=this.bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));

        book.setName(name);
        book.setAvailableCopies(availableCopies);

        Author author=this.authorRepository.findById(authorId).orElseThrow(()->new RuntimeException("Author not found"));
        book.setAuthor(author);

        BookCategory category=BookCategory.values()[bookCategory];
        book.setCategory(category);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author=this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(()->new RuntimeException("Author not found"));
        book.setAuthor(author);

        BookCategory category=BookCategory.values()[bookDto.getCategory()];
        book.setCategory(category);
        this.bookRepository.save(book);
        return Optional.of(book);    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
