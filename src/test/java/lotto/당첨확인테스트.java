package lotto;

import lotto.domain.ConfirmWinnings;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 당첨확인테스트 {
    private final List<Integer> win=new ArrayList<>();
    private final List<Integer> my=new ArrayList<>();


    @Test
    void 당첨최종테스트(){
        ConfirmWinnings confirmWinnings=new ConfirmWinnings();
        win.add(1); win.add(2); win.add(3); win.add(4); win.add(5); win.add(6);
        my.add(1); my.add(2); my.add(3); my.add(4); my.add(5); my.add(7);
        Lotto winningLotto=new Lotto(win);
        Lotto myLotto=new Lotto(my);
        Integer bonusNumber=7;

        Assertions.assertThat(LottoInfo.SECOND).isEqualTo(confirmWinnings.resultOfLotto(winningLotto, myLotto, bonusNumber));

    }
//
//    @Test
//    void 당첨개수테스트(){
//        numbers.clear();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(6);
//        Lotto winningLotto=new Lotto(numbers);
//        Lotto myLotto=new Lotto(numbers);
//
//        Assertions.assertThat(6).isEqualTo(confirmWinnings.matchNumberCount(winningLotto, myLotto));
//    }
//
//    @Test
//    void 보너스번호테스트(){
//        numbers.clear();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(7);
//        Lotto myLotto=new Lotto(numbers);
//        Integer bonusNumber=7;
//
//        Assertions.assertThat(true).isEqualTo(confirmWinnings.bonusNumberMatch(bonusNumber, myLotto));
//    }
}
