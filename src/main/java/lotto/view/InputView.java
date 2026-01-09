package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.Parser;
import lotto.util.Validator;

public class InputView {

    public Integer inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                Integer input = Parser.parseInt(Console.readLine());
                Validator.validatePurchaseAmount(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //여기서 리스트로 변환 후 반환해도 되는지?
    public String inputWinningLotto() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                Validator.validateWinningLotto(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                Integer input = Parser.parseInt(Console.readLine());
                Validator.validateBonusNumber(input, winningLotto);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
