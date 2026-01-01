package lotto.domain;

public enum LottoInfo {

    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    MISS(0,false, 0L);

    private final int matchNumbers;
    private final boolean bonusMatch;
    private final Long prize;

    LottoInfo(int matchNumbers, boolean bonusMatch, Long prize){
        this.matchNumbers=matchNumbers;
        this.bonusMatch=bonusMatch;
        this.prize=prize;
    }

    public Long getPrize(){
        return prize;
    }

}
