package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.MoneyChanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStoreTest {

    MoneyChanger moneyChanger;

    @BeforeEach
    void setUp() {
        moneyChanger = money -> money / 1000;
    }

    @Test
    @DisplayName("가격에 따른 로또 개수 테스트")
    void change() {
        int result = moneyChanger.change(1000 * 10);

        assertEquals(10, result);
    }

    @Test
    @DisplayName("가격에 따른 로또 생성 개수 테스트")
    void buy() {
        LottoStore lottoStore = new LottoStore(moneyChanger);

        List<Lotto> lottoList = lottoStore.buy(1000 * 10);

        assertEquals(10, lottoList.size());
    }
}
