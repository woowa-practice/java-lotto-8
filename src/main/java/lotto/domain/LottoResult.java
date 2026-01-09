package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results;
    private long totalPrize;

    public LottoResult(){
        this.results=new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        this.totalPrize=0;
    }

    public void add(Rank rank){
        results.put(rank, results.get(rank)+1);
        totalPrize+= rank.getPrize();
    }

    public Map<Rank, Integer> getResults(){
        return Collections.unmodifiableMap(results);
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
