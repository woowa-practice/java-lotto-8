package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Validator {

    public static void validatePurchaseAmount(Integer input) {
        amountIsNull(input);
        lessThanPrice(input);
        invalidPrice(input);
    }

    public static void validateWinningLotto(String input) {
        lottoInputIsNull(input);
        List<Integer> list = Parser.parseIntegerList(input);
        lottoNumberOutOfRange(list);
        duplicatedLottoNumber(list);
    }

    public static void validateBonusNumber(Integer input, Lotto winningLotto) {
        bonusNumberIsNull(input);
        bonusNumberOutOfRange(input);
        duplicatedBonusNumber(input, winningLotto);
    }

    private static void amountIsNull(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해 주세요.");
        }
    }

    private static void lessThanPrice(Integer input) {
        if (input < 1000) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해 주세요.");
        }
    }

    private static void invalidPrice(Integer input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해 주세요.");
        }
    }

    private static void lottoInputIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 올바른 번호를 입력해 주세요.");
        }
    }

    private static void lottoNumberOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 범위를 벗어난 번호가 포함됐습니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void duplicatedLottoNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다. 다시 입력해 주세요.");
        }
    }

    private static void bonusNumberIsNull(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 올바른 번호를 입력해 주세요.");
        }
    }

    private static void bonusNumberOutOfRange(Integer input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 범위를 벗어났습니다. 다시 입력해 주세요.");
        }
    }

    private static void duplicatedBonusNumber(Integer input, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요.");
        }
    }
}