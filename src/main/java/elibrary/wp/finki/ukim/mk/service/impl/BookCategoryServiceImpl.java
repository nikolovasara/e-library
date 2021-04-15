package elibrary.wp.finki.ukim.mk.service.impl;

import elibrary.wp.finki.ukim.mk.model.dto.BookCategoryDto;
import elibrary.wp.finki.ukim.mk.model.enumerations.BookCategory;
import elibrary.wp.finki.ukim.mk.service.BookCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Override
    public List<BookCategoryDto> findAll() {
        return Arrays.stream(BookCategory.values()).map((value)->new BookCategoryDto((long) value.ordinal(),value.toString())).collect(Collectors.toList());
    }
}
