package lotto;

import lotto.domain.*;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoGame {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int payPrice = scanner.nextInt();
        scanner.nextLine();
        LottoStore lottoStore = new LottoStore();
        LottoStorage lottoStorage = new LottoStorage(lottoStore.buy(payPrice));

        System.out.println(lottoStorage.numberOfLotto() + "개를 구매했습니다.");
        ResultView.printLottos(lottoStorage);

        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String winningLottoNum = scanner.nextLine();
        String[] winningLottoNumbers = winningLottoNum.split(", ");
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        System.out.println("당첨 통계");
        System.out.println("---------");
        LottoResult lottoResult =  winningLotto.match(lottoStorage);

    }
}
