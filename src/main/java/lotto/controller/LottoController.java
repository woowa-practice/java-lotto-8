package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningInfo;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int amount = inputView.inputPurchaseAmount();
        int count = amount / 1000;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateLotto());
            lottoList.add(lotto);
        }
        Lottos lottos = new Lottos(lottoList);

        outputView.outputRandomLotto(count, lottos.getLottos());

        Lotto winningLotto=new Lotto(inputView.inputWinningLotto());

        int bonusNumber = inputView.inputBonusNumber(winningLotto);

        WinningInfo winningInfo=new WinningInfo(winningLotto, bonusNumber);

        LottoResult lottoResult = lottos.calculateResult(winningInfo);

        lottoResult.calculateYield(amount);

        outputView.outputLottoResult(lottoResult);
    }
}
