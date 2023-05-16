package lotto.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRateCalculator {

    public static String calculateProfitRate(int money, Long winningMoney) {
        BigDecimal decimal = BigDecimal.valueOf((double) winningMoney / money).setScale(2, RoundingMode.DOWN);
        return String.format("%.2f", decimal);
    }
}
