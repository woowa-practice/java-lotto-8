package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    private final LottoResult lottoResult=new LottoResult();

    @Test
    void 당첨결과저장테스트(){
        lottoResult.add(Rank.SECOND);
        Assertions.assertThat(lottoResult.getResults()).containsKey(Rank.SECOND);
    }

    @Test
    void 총상금테스트(){
        long prize=Rank.SECOND.getPrize()*2;

        lottoResult.add(Rank.SECOND);
        lottoResult.add(Rank.SECOND);

        System.out.println(lottoResult.getTotalPrize());

        Assertions.assertThat(lottoResult.getTotalPrize()).isEqualTo(prize);
    }
}
