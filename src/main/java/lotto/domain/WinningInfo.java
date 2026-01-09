package lotto.domain;

public class WinningInfo {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningInfo(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        int count = (int) winningLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.from(count, bonusMatch);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (!winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
