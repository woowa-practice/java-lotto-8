package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private Parser(){}

    public static int parseInt(String input){
        try{
            return Integer.parseInt(input.trim());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static List<Integer> parseIntegerList(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Parser::parseInt)
                .collect(Collectors.toList());
    }
}
