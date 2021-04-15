package elibrary.wp.finki.ukim.mk.service;

import elibrary.wp.finki.ukim.mk.model.Book;
import elibrary.wp.finki.ukim.mk.model.dto.BookCategoryDto;

import java.util.List;

public interface BookCategoryService {
    List<BookCategoryDto> findAll();
}
