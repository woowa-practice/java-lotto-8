package lotto;

import lotto.domain.ConfirmWinnings;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 당첨확인테스트 {
    private final ConfirmWinnings confirmWinnings=new ConfirmWinnings();
    private final List<Integer> numbers=new ArrayList<>();

    @Test
    void 당첨개수테스트(){
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto winningLotto=new Lotto(numbers);
        Lotto myLotto=new Lotto(numbers);

        Assertions.assertThat(6).isEqualTo(confirmWinnings.matchNumberCount(winningLotto, myLotto));
    }

    @Test
    void 보너스번호테스트(){
        numbers.clear();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        Lotto myLotto=new Lotto(numbers);
        Integer bonusNumber=7;

        Assertions.assertThat(true).isEqualTo(confirmWinnings.bonusNumberMatch(bonusNumber, myLotto));
    }
}
