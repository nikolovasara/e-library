package elibrary.wp.finki.ukim.mk.repository;

import elibrary.wp.finki.ukim.mk.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
