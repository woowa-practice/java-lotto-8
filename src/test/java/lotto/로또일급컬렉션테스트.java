package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 로또일급컬렉션테스트 {

    private final Lotto lotto1=new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
    private final Lotto lotto2=new Lotto(new ArrayList<>(List.of(11,12,13,14,15,16)));
    private final Lotto lotto3=new Lotto(new ArrayList<>(List.of(21,22,23,24,25,26)));

    private final Lottos lottos=new Lottos(List.of(lotto1, lotto2, lotto3));

    @Test
    void 로또일급컬렉션테스트(){
        Assertions.assertThat(lottos.getLottos()).contains(lotto1);
        Assertions.assertThat(lottos.getLottos()).contains(lotto2);
        Assertions.assertThat(lottos.getLottos()).contains(lotto3);
    }
}
