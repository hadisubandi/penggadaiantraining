package id.co.penggadaian.backend.training.service;

import id.co.penggadaian.backend.training.domain.HargaPenutupan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link HargaPenutupan}.
 */
public interface HargaPenutupanService {

    /**
     * Save a hargaPenutupan.
     *
     * @param hargaPenutupan the entity to save.
     * @return the persisted entity.
     */
    HargaPenutupan save(HargaPenutupan hargaPenutupan);

    /**
     * Get all the hargaPenutupans.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<HargaPenutupan> findAll(Pageable pageable);


    /**
     * Get the "id" hargaPenutupan.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<HargaPenutupan> findOne(Long id);

    /**
     * Delete the "id" hargaPenutupan.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
