package id.co.penggadaian.backend.training.web.rest;

import id.co.penggadaian.backend.training.domain.HargaPenutupan;
import id.co.penggadaian.backend.training.service.HargaPenutupanService;
import id.co.penggadaian.backend.training.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link id.co.penggadaian.backend.training.domain.HargaPenutupan}.
 */
@RestController
@RequestMapping("/api")
public class HargaPenutupanResource {

    private final Logger log = LoggerFactory.getLogger(HargaPenutupanResource.class);

    private static final String ENTITY_NAME = "hargaPenutupan";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final HargaPenutupanService hargaPenutupanService;

    public HargaPenutupanResource(HargaPenutupanService hargaPenutupanService) {
        this.hargaPenutupanService = hargaPenutupanService;
    }

    /**
     * {@code POST  /harga-penutupans} : Create a new hargaPenutupan.
     *
     * @param hargaPenutupan the hargaPenutupan to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new hargaPenutupan, or with status {@code 400 (Bad Request)} if the hargaPenutupan has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/harga-penutupans")
    public ResponseEntity<HargaPenutupan> createHargaPenutupan(@Valid @RequestBody HargaPenutupan hargaPenutupan) throws URISyntaxException {
        log.debug("REST request to save HargaPenutupan : {}", hargaPenutupan);
        if (hargaPenutupan.getId() != null) {
            throw new BadRequestAlertException("A new hargaPenutupan cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HargaPenutupan result = hargaPenutupanService.save(hargaPenutupan);
        return ResponseEntity.created(new URI("/api/harga-penutupans/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /harga-penutupans} : Updates an existing hargaPenutupan.
     *
     * @param hargaPenutupan the hargaPenutupan to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated hargaPenutupan,
     * or with status {@code 400 (Bad Request)} if the hargaPenutupan is not valid,
     * or with status {@code 500 (Internal Server Error)} if the hargaPenutupan couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/harga-penutupans")
    public ResponseEntity<HargaPenutupan> updateHargaPenutupan(@Valid @RequestBody HargaPenutupan hargaPenutupan) throws URISyntaxException {
        log.debug("REST request to update HargaPenutupan : {}", hargaPenutupan);
        if (hargaPenutupan.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HargaPenutupan result = hargaPenutupanService.save(hargaPenutupan);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, hargaPenutupan.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /harga-penutupans} : get all the hargaPenutupans.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of hargaPenutupans in body.
     */
    @GetMapping("/harga-penutupans")
    public ResponseEntity<List<HargaPenutupan>> getAllHargaPenutupans(Pageable pageable) {
        log.debug("REST request to get a page of HargaPenutupans");
        Page<HargaPenutupan> page = hargaPenutupanService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /harga-penutupans/:id} : get the "id" hargaPenutupan.
     *
     * @param id the id of the hargaPenutupan to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the hargaPenutupan, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/harga-penutupans/{id}")
    public ResponseEntity<HargaPenutupan> getHargaPenutupan(@PathVariable Long id) {
        log.debug("REST request to get HargaPenutupan : {}", id);
        Optional<HargaPenutupan> hargaPenutupan = hargaPenutupanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(hargaPenutupan);
    }

    /**
     * {@code DELETE  /harga-penutupans/:id} : delete the "id" hargaPenutupan.
     *
     * @param id the id of the hargaPenutupan to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/harga-penutupans/{id}")
    public ResponseEntity<Void> deleteHargaPenutupan(@PathVariable Long id) {
        log.debug("REST request to delete HargaPenutupan : {}", id);
        hargaPenutupanService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
