package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoInfo, Integer> results;

    public LottoResult(Map<LottoInfo, Integer> results) {
        this.results = results;

        for (LottoInfo lottoInfo : LottoInfo.values()) {
            this.results.put(lottoInfo, 0);
        }
    }

    public void add(LottoInfo lottoInfo) {
        results.put(lottoInfo, results.get(lottoInfo) + 1);
    }

    public int getCount(LottoInfo lottoInfo) {
        return results.getOrDefault(lottoInfo, 0);
    }

    public double calculateYield(Integer amount) {
        long totalPrize = 0;

        for (LottoInfo lottoInfo : results.keySet()) {
            int count = results.get(lottoInfo);
            totalPrize += (long) lottoInfo.getPrize() * count;
        }

        return ((double) totalPrize / amount) * 100;
    }
}
