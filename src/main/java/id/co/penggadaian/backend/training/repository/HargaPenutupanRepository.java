package id.co.penggadaian.backend.training.repository;

import id.co.penggadaian.backend.training.domain.HargaPenutupan;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the HargaPenutupan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HargaPenutupanRepository extends JpaRepository<HargaPenutupan, Long> {

}
