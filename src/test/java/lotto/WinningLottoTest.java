package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoTest {
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
    }

    static Stream<Arguments> lottoData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoData")
    @DisplayName("당첨개수를 제대로 반환하는지")
    void match(Lotto lotto, int expected) {
        int matchCount = winningLotto.match(lotto);

        assertEquals(matchCount, expected);
    }

}
