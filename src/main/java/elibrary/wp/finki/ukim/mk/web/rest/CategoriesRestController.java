package elibrary.wp.finki.ukim.mk.web.rest;

import elibrary.wp.finki.ukim.mk.model.dto.BookCategoryDto;
import elibrary.wp.finki.ukim.mk.model.enumerations.BookCategory;
import elibrary.wp.finki.ukim.mk.service.BookCategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesRestController {
    private final BookCategoryService bookCategoryService;

    public CategoriesRestController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    private List<BookCategoryDto> findAll() {
        return bookCategoryService.findAll();
    }
}
