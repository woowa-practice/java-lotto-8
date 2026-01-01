package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int CHOOSE_NUM = 6;

    public List<Integer> generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, CHOOSE_NUM);
        Collections.sort(lotto);
        return lotto;
    }
}
