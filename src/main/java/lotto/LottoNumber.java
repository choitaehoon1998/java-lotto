package lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private final Integer lottoNumber;
    private static final int LOTTO_MIN = 1;
    private static final int LOTT_MAX = 45;

    public LottoNumber(Integer lottoNumber) {
        if (lottoNumber < LOTTO_MIN || lottoNumber > LOTT_MAX) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber.compareTo(lottoNumber.lottoNumber);
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }
}
