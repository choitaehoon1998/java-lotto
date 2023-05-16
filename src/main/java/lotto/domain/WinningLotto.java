package lotto.domain;

import lotto.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningLottoNumbers = new ArrayList<>();

    public WinningLotto(String[] winningLottoNumbers) {
        for (String winningLottoNumber : winningLottoNumbers) {
            this.winningLottoNumbers.add(new LottoNumber(Integer.parseInt(winningLottoNumber)));
        }
    }

    public WinningLotto(List<Integer> winningLottoNumbers) {
        for (Integer winningLottoNumber : winningLottoNumbers) {
            this.winningLottoNumbers.add(new LottoNumber(winningLottoNumber));
        }
    }

    public int match(Lotto lotto) {
        return Math.toIntExact(lotto.getLottoNumbers().stream().filter(winningLottoNumbers::contains).count());
    }

    public LottoResult match(LottoStorage lottoStorage) {
        List<Integer> matchResult = new ArrayList<>();
        for (Lotto lotto : lottoStorage.getLottoList()) {
            matchResult.add(this.match(lotto));
        }
        return LottoResult.of(matchResult);

    }
}
