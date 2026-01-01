package lotto.domain;

public enum LottoInfo {

    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    MISS(0, false, 0L);

    private final int matchNumbers;
    private final boolean bonusMatch;
    private final Long prize;

    LottoInfo(int matchNumbers, boolean bonusMatch, Long prize) {
        this.matchNumbers = matchNumbers;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static LottoInfo valueOf(int matchNumbers, boolean bonusMatch) {
        if (matchNumbers == 6) {
            return FIRST;
        }
        if (matchNumbers == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchNumbers == 5) {
            return THIRD;
        }
        if (matchNumbers == 4) {
            return FOURTH;
        }
        if (matchNumbers == 3) {
            return FIFTH;
        } else {
            return MISS;
        }
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public Long getPrize() {
        return prize;
    }

}
