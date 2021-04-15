package elibrary.wp.finki.ukim.mk.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER, ROLE_ADMIN, ROLE_LIBRARIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
