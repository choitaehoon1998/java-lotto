package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_MIN_NUMBER_INCLUSIVE = 1;
    private static final int LOTTO_MAX_NUMBER_EXCLUSIVE = 46;
    private static final List<Integer> LOTTO_NUMBERS_POOL = IntStream
            .range(LOTTO_MIN_NUMBER_INCLUSIVE, LOTTO_MAX_NUMBER_EXCLUSIVE)
            .boxed()
            .collect(Collectors.toList());

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS_POOL);
        List<Integer> lottoNumbers = LOTTO_NUMBERS_POOL.subList(0, 6);
        for (Integer lottoNumber : lottoNumbers) {
            this.lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        this.sort();
    }

    public Lotto(List<Integer> lottoList) {
        for (Integer lottoNumber : lottoList) {
            this.lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        this.sort();
    }

    private void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }
}

