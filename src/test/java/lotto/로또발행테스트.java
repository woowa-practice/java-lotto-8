package lotto;

import lotto.domain.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 로또발행테스트 {

    private final LottoGenerator lottoGenerator=new LottoGenerator();

    @Test
    void 로또발행테스트개수(){
        Assertions.assertThat(6).isEqualTo(lottoGenerator.generateLotto().size());
    }

    @Test
    void 로또발행테스트중복(){
        Assertions.assertThat(lottoGenerator.generateLotto()).doesNotHaveDuplicates();
    }
}
