package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTest {
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("생성된 로또의 모든 번호가 1~45")
    void checkLottoNumbersIsInRange() {
        lotto = new Lotto();
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            assertThat(lottoNumber.getLottoNumber()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("생성된 로또 숫자 의 개수가 6개")
    void checkLottoCountIsSix() {
        assertThat(lotto.getLottoNumbers()).size().isEqualTo(6);
    }
}
