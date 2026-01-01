package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusNumber){
        this.winningLotto=winningLotto;
        this.bonusNumber=bonusNumber;
    }

    public LottoInfo resultOfLotto(Lotto myLotto) {
        int matchCount = matchNumberCount(myLotto);
        boolean bonusMatch = bonusNumberMatch(myLotto);
        return LottoInfo.valueOf(matchCount, bonusMatch);
    }

    private int matchNumberCount(Lotto myLotto) {

        long matchCount = myLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        return (int) matchCount;
    }

    private boolean bonusNumberMatch(Lotto myLotto) {
        return myLotto.getNumbers().contains(bonusNumber);
    }
}
