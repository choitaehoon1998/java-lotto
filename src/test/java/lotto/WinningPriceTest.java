package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WinningPriceTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3, 5000", "4, 50000", "5, 1500000", "6, 2000000000"})
    @DisplayName("당첨 개수에 따른 상금을 제대로 반환하는지")
    void getWiningPrice(int matchCount, Long expected) {
        Long winningPrice = WinningPrice.getWiningPrice(matchCount);

        assertEquals(winningPrice, expected);
    }
}