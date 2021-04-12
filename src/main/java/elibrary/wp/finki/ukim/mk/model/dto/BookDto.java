package elibrary.wp.finki.ukim.mk.model.dto;

import elibrary.wp.finki.ukim.mk.model.Author;
import elibrary.wp.finki.ukim.mk.model.enumerations.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String name;

    private Integer category;

    private Long author;

    private Integer availableCopies;
}
