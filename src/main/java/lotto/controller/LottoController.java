package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView){
        this.inputView=inputView;
        this.outputView=outputView;
    }

    public void run(){
        int amount=inputView.inputPurchaseAmount();
        int count=amount/1000;

        List<Lotto> lottoList=new ArrayList<>();
        for(int i=0; i<count; i++){
            Lotto lotto=new Lotto(LottoGenerator.generateLotto());
            lottoList.add(lotto);
        }
        Lottos lottos=new Lottos(lottoList);

        outputView.outputRandomLotto(count, lottos.getLottos());

        String winningNumber= inputView.inputWinningLotto();
        Lotto winningLotto=new Lotto(Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int bonusNumber= inputView.inputBonusNumber();

        LottoResult lottoResult=new LottoResult();

        for (Lotto lotto : lottos.getLottos()) {
            lottoResult.add(LottoService.calculateRank(winningLotto, bonusNumber, lotto));
        }
        lottoResult.setYield(LottoService.calculateYield(lottoResult.getTotalPrize(), amount));

        outputView.outputLottoResult(lottoResult);
    }
}
