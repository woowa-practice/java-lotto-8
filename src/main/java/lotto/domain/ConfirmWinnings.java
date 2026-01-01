package lotto.domain;

import java.util.List;

public class ConfirmWinnings {

    public int matchNumberCount(Lotto winningLotto, Lotto myLotto){
        List<Integer> win=winningLotto.getNumbers();
        List<Integer> my=myLotto.getNumbers();

        long matchCount=win.stream()
                .filter(number->my.contains(number))
                .count();

        return (int)matchCount;
    }

    public boolean bonusNumberMatch(Integer bonusNumber, Lotto myLotto){
        List<Integer> my=myLotto.getNumbers();

        return my.contains(bonusNumber);
    }
}
