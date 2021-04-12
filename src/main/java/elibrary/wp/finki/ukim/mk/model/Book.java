package elibrary.wp.finki.ukim.mk.model;

import elibrary.wp.finki.ukim.mk.model.enumerations.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(String name, BookCategory category, Author author, Integer availableCopies) {
        this.name=name;
        this.category=category;
        this.author=author;
        this.availableCopies=availableCopies;
    }
}
