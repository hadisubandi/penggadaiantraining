package id.co.penggadaian.backend.training.repository;

import id.co.penggadaian.backend.training.domain.Efek;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Efek entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EfekRepository extends JpaRepository<Efek, Long> {

}
