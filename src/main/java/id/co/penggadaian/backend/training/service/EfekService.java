package id.co.penggadaian.backend.training.service;

import id.co.penggadaian.backend.training.domain.Efek;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Efek}.
 */
public interface EfekService {

    /**
     * Save a efek.
     *
     * @param efek the entity to save.
     * @return the persisted entity.
     */
    Efek save(Efek efek);

    /**
     * Get all the efeks.
     *
     * @return the list of entities.
     */
    List<Efek> findAll();


    /**
     * Get the "id" efek.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Efek> findOne(Long id);

    /**
     * Delete the "id" efek.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
