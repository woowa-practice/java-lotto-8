package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> results;
    private final Double yield;

    public LottoResult(Double yield){
        this.results=new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        this.yield=yield;
    }

    public void add(Rank rank){
        results.put(rank, results.get(rank)+1);
    }

    public Map<Rank, Integer> getResults(){
        return Collections.unmodifiableMap(results);
    }

    public Double getYield(){
        return yield;
    }
}
