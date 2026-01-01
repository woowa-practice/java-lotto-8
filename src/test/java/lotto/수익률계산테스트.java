package lotto;

import lotto.domain.YieldCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 수익률계산테스트 {
    private final YieldCalculator yieldCalculator = new YieldCalculator();

    @Test
    void 수익률계산테스트() {
        Integer amount = 5000;
        Long prize = 8000L;
        Assertions.assertThat(62.5).isEqualTo(yieldCalculator.calculateYield(amount, prize));
    }
}
