package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult calculateResult(WinningLotto winningLotto){
        Map<LottoInfo, Integer> result=new EnumMap<>(LottoInfo.class);

        for(LottoInfo lottoInfo:LottoInfo.values()){
            result.put(lottoInfo, 0);
        }

        for (Lotto lotto : lottos) {
            LottoInfo lottoInfo=winningLotto.resultOfLotto(lotto);
            result.put(lottoInfo, result.get(lottoInfo) + 1);
        }

        return new LottoResult(result);
    }
}
