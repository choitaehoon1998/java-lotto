package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {

    @Test
    void match() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        Long matchPrice = winningLotto.match(lotto);
    }
}
