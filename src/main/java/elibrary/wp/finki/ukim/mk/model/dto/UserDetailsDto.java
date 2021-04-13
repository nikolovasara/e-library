package elibrary.wp.finki.ukim.mk.model.dto;

import elibrary.wp.finki.ukim.mk.model.User;
import elibrary.wp.finki.ukim.mk.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(User user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}

