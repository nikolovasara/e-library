package elibrary.wp.finki.ukim.mk.repository;

import elibrary.wp.finki.ukim.mk.model.User;
import elibrary.wp.finki.ukim.mk.model.enumerations.Role;
import elibrary.wp.finki.ukim.mk.model.projections.UserProjection;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"books"})
    @Query("select u from User u")
    List<User> fetchAll();

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {"books"})
    @Query("select u from User u")
    List<User> loadAll();

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    UserProjection findByRole(Role role);

    @Query("select u.username, u.name, u.surname from User u")
    List<UserProjection> takeUsernameAndNameAndSurnameByProjection();
}

