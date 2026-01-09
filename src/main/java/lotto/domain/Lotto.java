package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        isDuplicated(numbers);
    }

    private void isDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public Rank calculateRank(Lotto winningLotto, int bonusNumber){
        int count=(int) winningLotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
        boolean bonusMatch=numbers.contains(bonusNumber);
        return Rank.from(count, bonusMatch);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
