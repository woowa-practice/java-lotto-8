package lotto.domain;

import java.util.List;

public class ConfirmWinnings {

    public LottoInfo resultOfLotto(Lotto winningLotto, Lotto myLotto, Integer bonusNumber) {
        int matchCount = matchNumberCount(winningLotto, myLotto);
        boolean bonusMatch = bonusNumberMatch(bonusNumber, myLotto);
        return LottoInfo.valueOf(matchCount, bonusMatch);
    }

    private int matchNumberCount(Lotto winningLotto, Lotto myLotto) {
        List<Integer> win = winningLotto.getNumbers();
        List<Integer> my = myLotto.getNumbers();

        long matchCount = win.stream()
                .filter(my::contains)
                .count();

        return (int) matchCount;
    }

    private boolean bonusNumberMatch(Integer bonusNumber, Lotto myLotto) {
        List<Integer> my = myLotto.getNumbers();

        return my.contains(bonusNumber);
    }
}
