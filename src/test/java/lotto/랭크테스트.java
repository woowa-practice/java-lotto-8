package lotto;

import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 랭크테스트 {

    @Test
    void 랭크테스트(){
        Assertions.assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD);
    }
}
