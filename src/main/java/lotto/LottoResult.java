package lotto;

import java.util.List;

public class LottoResult {
    private int match0;
    private int match1;
    private int match2;
    private int match3;
    private int match4;
    private int match5;
    private int match6;

    public static LottoResult of(List<Integer> matchResult) {
        LottoResult lottoResult = new LottoResult();
        for (Integer match : matchResult) {
            lottoResult.update(match);
        }
        return lottoResult;
    }

    private void update(Integer match) {
        switch (match) {
            case 0:
                match0++;
                break;
            case 1:
                match1++;
                break;
            case 2:
                match2++;
                break;
            case 3:
                match3++;
                break;
            case 4:
                match4++;
                break;
            case 5:
                match5++;
                break;
            case 6:
                match6++;
                break;
        }
    }
}
