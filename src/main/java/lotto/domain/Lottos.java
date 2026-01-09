package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public LottoResult calculateResult(Lotto winningLotto, int bonusNumber){
        LottoResult result=new LottoResult();
        for (Lotto lotto : lottos) {
            result.add(lotto.calculateRank(winningLotto, bonusNumber));
        }
        return result;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
