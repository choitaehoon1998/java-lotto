package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아닐 경우 예외 발생")
    void lottoNumberIsNotBetweenRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(0);
        });
    }

}
