package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public void outputRandomLotto(Integer count, List<Lotto> lottos){
        System.out.println(count+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> list = new ArrayList<>(lotto.getNumbers());
            Collections.sort(list);
            System.out.println(list);
        }
    }

    public void outputLottoResult(LottoResult result){
        System.out.println("\n당첨 통계" +
                "\n---");

        for (Rank rank : result.getResults().keySet()) {
            if(rank==Rank.MISS) continue;
            System.out.println(rank.getDescription()+result.getResults().get(rank)+"개");
//            System.out.print(rank.getMatchCount()+"개 일치 (");
//            System.out.printf("%,d", rank.getPrize());
//            System.out.print("원) - "+result.getResults().get(rank)+"개");
//            System.out.println();
        }

        System.out.println("총 수익률은 "+result.getYield()+"%입니다.");
    }
}
