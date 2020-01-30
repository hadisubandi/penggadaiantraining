package id.co.penggadaian.backend.training.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.co.penggadaian.backend.training.web.rest.TestUtil;

public class EfekTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Efek.class);
        Efek efek1 = new Efek();
        efek1.setId(1L);
        Efek efek2 = new Efek();
        efek2.setId(efek1.getId());
        assertThat(efek1).isEqualTo(efek2);
        efek2.setId(2L);
        assertThat(efek1).isNotEqualTo(efek2);
        efek1.setId(null);
        assertThat(efek1).isNotEqualTo(efek2);
    }
}
