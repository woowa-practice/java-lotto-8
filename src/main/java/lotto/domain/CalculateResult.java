package lotto.domain;

public class CalculateResult {

    //당첨로또+보너스번호랑 발행로또 하나 비교해서 몇개 맞는지 반환
    public static Rank calculateRank(Lotto winningLotto, int bonusNumber, Lotto lotto){
        int matchCount=countMatch(winningLotto, lotto);
        boolean bonusMatch=isBonusMatch(bonusNumber, lotto);
        return Rank.from(matchCount, bonusMatch);
    }

    //수익률 반환
    public static double calculateYield(long totalPrize, int amount){
        return ((double)totalPrize/amount)*100;
    }

    //몇개 맞는지
    private static int countMatch(Lotto winningLotto, Lotto lotto){
        return (int) winningLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }
    
    //보너스 포함인지
    private static boolean isBonusMatch(int bonusNumber, Lotto lotto){
        return lotto.getNumbers().contains(bonusNumber);
    }
}
