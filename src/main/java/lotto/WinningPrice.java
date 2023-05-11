package lotto;

import java.util.Arrays;

public enum WinningPrice {
    MATCH_ZERO(0, 0L),
    MATCH_ONE(1, 0L),
    MATCH_TWO(2, 0L),
    MATCH_THREE(3, 5000L),
    MATCH_FOUR(4, 50000L),
    MATCH_FIVE(5, 1500000L),
    MATCH_SIX(6, 2000000000L);
    private final int matchCount;
    private final Long winningPrice;

    WinningPrice(int matchCount, Long winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    private static WinningPrice of(int matchCount) {
        return Arrays.stream(values())
                .filter(winningPrice -> winningPrice.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨 개수에 해당하는 상금이 없습니다."));
    }

    public static Long getWiningPrice(int matchCount) {
        return of(matchCount).winningPrice;
    }
}
