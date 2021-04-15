package elibrary.wp.finki.ukim.mk.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;

    private String surname;

    private Long country;
}
