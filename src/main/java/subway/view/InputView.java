package subway.view;

import java.util.Scanner;

import static subway.view.MessagePrefix.OUTPUT_PREFIX;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMainMenu() {
        System.out.println(OUTPUT_PREFIX + "원하는 기능을 선택하세요.");
        String input = scanner.next();
        System.out.println();
        return input;
    }
}
