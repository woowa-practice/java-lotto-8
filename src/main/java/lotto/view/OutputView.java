package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {

    public void outputRandomLotto(Integer count, List<Lotto> lottos){
        System.out.println("\n"+count+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputLottoResult(LottoResult result){
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(result.getResults());

        System.out.println("총 수익률은 "+result.getYield()+"%입니다.");
    }
}
