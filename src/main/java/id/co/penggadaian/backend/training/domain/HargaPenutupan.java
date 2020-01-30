package id.co.penggadaian.backend.training.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A HargaPenutupan.
 */
@Entity
@Table(name = "harga_penutupan")
public class HargaPenutupan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "tanggal", nullable = false)
    private LocalDate tanggal;

    @DecimalMin(value = "0")
    @Column(name = "harga")
    private Double harga;

    @ManyToOne
    @JsonIgnoreProperties("hargaPenutupans")
    private Efek efek;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public HargaPenutupan tanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
        return this;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public Double getHarga() {
        return harga;
    }

    public HargaPenutupan harga(Double harga) {
        this.harga = harga;
        return this;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Efek getEfek() {
        return efek;
    }

    public HargaPenutupan efek(Efek efek) {
        this.efek = efek;
        return this;
    }

    public void setEfek(Efek efek) {
        this.efek = efek;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HargaPenutupan)) {
            return false;
        }
        return id != null && id.equals(((HargaPenutupan) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "HargaPenutupan{" +
            "id=" + getId() +
            ", tanggal='" + getTanggal() + "'" +
            ", harga=" + getHarga() +
            "}";
    }
}
