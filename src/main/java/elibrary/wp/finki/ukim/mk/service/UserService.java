package elibrary.wp.finki.ukim.mk.service;

import elibrary.wp.finki.ukim.mk.model.User;
import elibrary.wp.finki.ukim.mk.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}