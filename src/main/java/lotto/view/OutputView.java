package lotto.view;

import java.util.List;

public class OutputView {

    public void outputRandomLotto(Integer amount, List<String> lottos){
        System.out.println(amount+"개를 구매했습니다.");
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void outputLottoResult(){
        System.out.println("당첨 통계");
        System.out.println("---");

    }
}
