package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, false, 0, ""),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean bonusMatch;
    private final long prize;
    private final String description;

    Rank(int matchCount, boolean bonusMatch, long prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.description = description;
    }

    public static Rank from(int matchCount, boolean bonusMatch) {
        if (matchCount == SECOND.matchCount && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank != SECOND)
                .findFirst()
                .orElse(MISS);
    }

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }
}
