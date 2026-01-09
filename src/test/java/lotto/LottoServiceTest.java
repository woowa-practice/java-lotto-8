package lotto;

import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceTest {
    private final Lotto winningLotto=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
    private final int bonusNumber=7;
    private final int amount=3000;
    private final Lotto lotto1=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
    private final Lotto lotto2=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,7)));
    private final Lotto lotto3=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,8)));
    private final LottoResult lottoResult=new LottoResult();

    @Test
    void 당첨랭크테스트(){
        Assertions.assertThat(LottoService.calculateRank(winningLotto, bonusNumber, lotto1)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(LottoService.calculateRank(winningLotto, bonusNumber, lotto2)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(LottoService.calculateRank(winningLotto, bonusNumber, lotto3)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 수익률계산테스트(){
        lottoResult.add(LottoService.calculateRank(winningLotto, bonusNumber, lotto1));
        lottoResult.add(LottoService.calculateRank(winningLotto, bonusNumber, lotto2));
        lottoResult.add(LottoService.calculateRank(winningLotto, bonusNumber, lotto3));

        double prize= ((double) 2031500000 /3000)*100;
        Assertions.assertThat(LottoService.calculateYield(lottoResult.getTotalPrize(), amount))
                .isEqualTo(prize);
    }
}
