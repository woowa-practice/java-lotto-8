package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.domain.Lottos;

import java.util.List;

public class LottoOutputView {

    public void outputPurchasedLotto(Integer amount, Lottos lottos){
        System.out.println(amount+"개를 구매했습니다.");
        List<Lotto> lottoList=lottos.getLottos();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public void startResultOutput(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void outputLottoResult(int matchNumberCount, boolean bonusMatch, double yield){


    }
}
