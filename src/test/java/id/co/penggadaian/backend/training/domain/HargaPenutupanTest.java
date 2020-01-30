package id.co.penggadaian.backend.training.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.co.penggadaian.backend.training.web.rest.TestUtil;

public class HargaPenutupanTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(HargaPenutupan.class);
        HargaPenutupan hargaPenutupan1 = new HargaPenutupan();
        hargaPenutupan1.setId(1L);
        HargaPenutupan hargaPenutupan2 = new HargaPenutupan();
        hargaPenutupan2.setId(hargaPenutupan1.getId());
        assertThat(hargaPenutupan1).isEqualTo(hargaPenutupan2);
        hargaPenutupan2.setId(2L);
        assertThat(hargaPenutupan1).isNotEqualTo(hargaPenutupan2);
        hargaPenutupan1.setId(null);
        assertThat(hargaPenutupan1).isNotEqualTo(hargaPenutupan2);
    }
}
