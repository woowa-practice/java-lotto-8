package lotto.domain;

public class YieldCalculator {
    //당첨 / 구입
    public double calculateYield(Integer amount, Long prize) {
        return ((double) amount / prize) * 100;
    }
}
