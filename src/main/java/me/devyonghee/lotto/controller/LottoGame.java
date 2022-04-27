package me.devyonghee.lotto.controller;

import me.devyonghee.common.StringSeparator;
import me.devyonghee.common.StringsProvider;
import me.devyonghee.lotto.model.LottoGenerator;
import me.devyonghee.lotto.model.LottoNumber;
import me.devyonghee.lotto.model.LottoStore;
import me.devyonghee.lotto.model.Lottos;
import me.devyonghee.lotto.model.WinnerLotto;
import me.devyonghee.lotto.model.WinnerLottoGenerator;
import me.devyonghee.lotto.view.InputView;
import me.devyonghee.lotto.view.ResultView;
import me.devyonghee.lotto.view.dto.LottosResponse;
import me.devyonghee.lotto.view.dto.ScoreResponse;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class LottoGame {

    private static final String NULL_INPUT_STREAM_ERROR_MESSAGE = "inputStream must not be null";
    private static final String NULL_OUTPUT_ERROR_MESSAGE = "output must not be null";
    private static final String STRING_NUMBER_DELIMITER = ",";

    private final InputView inputView;
    private final ResultView resultView;

    private LottoGame(InputStream inputStream, PrintStream output) {
        Objects.requireNonNull(inputStream, NULL_INPUT_STREAM_ERROR_MESSAGE);
        Objects.requireNonNull(output, NULL_OUTPUT_ERROR_MESSAGE);
        this.inputView = InputView.of(new Scanner(inputStream), output);
        this.resultView = ResultView.from(output);
    }

    public static LottoGame of(InputStream inputStream, PrintStream output) {
        return new LottoGame(inputStream, output);
    }

    public void start() {
        Lottos lottos = LottoStore.of(inputView.purchaseAmount(), LottoGenerator.from(manualNumbersProviders())).lottos();
        resultView.print(LottosResponse.from(lottos));
        resultView.print(ScoreResponse.from(winnerLotto().score(lottos)));
    }

    private List<StringsProvider> manualNumbersProviders() {
        return inputView.manualNumbers()
                .stream()
                .map(string -> StringSeparator.of(string, STRING_NUMBER_DELIMITER))
                .collect(Collectors.toList());
    }

    private WinnerLotto winnerLotto() {
        return WinnerLottoGenerator.of(
                        StringSeparator.of(inputView.winnerNumbers(), STRING_NUMBER_DELIMITER),
                        LottoNumber.from(inputView.winnerBonusNumber()))
                .lotto();
    }
}
