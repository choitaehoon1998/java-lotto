package lotto;

import lotto.utils.ProfitRateCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfitRateCalculatorTest {

    @Test
    @DisplayName("정상적으로 수익률이 계산되는지")
    void calculate() {
        String profitRate = ProfitRateCalculator.calculateProfitRate(14000, 5000L);

        assertEquals("0.35", profitRate);
    }
}
