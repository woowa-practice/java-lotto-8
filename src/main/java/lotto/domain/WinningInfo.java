package lotto.domain;

public class WinningInfo {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningInfo(Lotto winningLotto, int bonusNumber){
        this.winningLotto=winningLotto;
        this.bonusNumber=bonusNumber;
    }

    public Rank calculateRank(Lotto lotto){
        int count=(int) winningLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
        boolean bonusMatch=lotto.getNumbers().contains(bonusNumber);
        return Rank.from(count, bonusMatch);
    }

    public Lotto getWinningLotto(){
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
