package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;

public class LottoOutputView {

    public void outputPurchasedLotto(Integer amount, Lottos lottos){
        System.out.println(amount+"개를 구매했습니다.");
        List<Lotto> lottoList=lottos.getLottos();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void startResultOutput(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void outputLottoResult(LottoResult result){
        List<LottoInfo> ranks=List.of(
                LottoInfo.FIFTH,LottoInfo.FOURTH,LottoInfo.THIRD,
                LottoInfo.SECOND, LottoInfo.FIRST
        );

        for (LottoInfo rank : ranks) {
            int count=result.getCount(rank);
            printRankInfo(rank, count);
        }
    }

    private void printRankInfo(LottoInfo rank, int count){
        String message=String.format("%d개 일치", rank.getMatchNumbers());

        if(rank.isBonusMatch()){
            message+="보너스 볼 일치";
        }

        System.out.printf("%s (%,d원) - %d개\n", message, rank.getPrize(), count);
    }

    public void outputYield(double yield){
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }
}
