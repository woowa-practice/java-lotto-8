package lotto;

import lotto.domain.CalculateResult;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateResultTest {
    private final Lotto winningLotto=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
    private final int bonusNumber=7;
    private final int amount=3000;
    private final Lotto lotto1=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
    private final Lotto lotto2=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,7)));
    private final Lotto lotto3=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,8)));
    private final LottoResult lottoResult=new LottoResult();

    @Test
    void 당첨랭크테스트(){
        Assertions.assertThat(CalculateResult.calculateRank(winningLotto, bonusNumber, lotto1)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(CalculateResult.calculateRank(winningLotto, bonusNumber, lotto2)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(CalculateResult.calculateRank(winningLotto, bonusNumber, lotto3)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 수익률계산테스트(){
        lottoResult.add(CalculateResult.calculateRank(winningLotto, bonusNumber, lotto1));
        lottoResult.add(CalculateResult.calculateRank(winningLotto, bonusNumber, lotto2));
        lottoResult.add(CalculateResult.calculateRank(winningLotto, bonusNumber, lotto3));

        double prize= ((double) 2031500000 /3000)*100;
        Assertions.assertThat(CalculateResult.calculateYield(lottoResult.getTotalPrize(), amount))
                .isEqualTo(prize);
    }
}
