package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(LottoInputView inputView, LottoOutputView outputView, LottoGenerator generator){
        this.lottoInputView=inputView;
        this.lottoOutputView=outputView;
        this.lottoGenerator=generator;
    }

    public void run(){
        Integer amount=lottoInputView.inputLottoAmount()/1000;

        List<Lotto> lottoList=new ArrayList<>();
        for(int i=0; i<amount; i++){
            Lotto lotto=new Lotto(lottoGenerator.generateLotto());
            lottoList.add(lotto);
        }

        Lottos lottos=new Lottos(lottoList);

        lottoOutputView.outputPurchasedLotto(amount, lottos);

        String[] inputWin=lottoInputView.inputLottoNumber().split(",");
        List<Integer> win=new ArrayList<>();
        for (String s : inputWin) {
            win.add(Integer.parseInt(s.trim()));
        }

        Lotto winningLotto=new Lotto(win);

        Integer bonusNumber=lottoInputView.inputBonusNumber();

        lottoOutputView.startResultOutput();


    }
}
