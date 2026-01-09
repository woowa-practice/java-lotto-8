package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0,false,0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final long prize;

    Rank(int matchCount, boolean bonusMatch, long prize){
        this.matchCount=matchCount;
        this.bonusMatch=bonusMatch;
        this.prize=prize;
    }

    public static Rank from(int matchCount, boolean bonusMatch){
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount==matchCount&&rank.bonusMatch==bonusMatch)
                .findFirst()
                .orElse(MISS);
    }

    public long getPrize() {
        return prize;
    }
}
