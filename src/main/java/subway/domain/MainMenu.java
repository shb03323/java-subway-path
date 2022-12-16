package subway.domain;

import java.util.Arrays;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public enum MainMenu {

    SEARCH_ROUTE("1"),
    QUIT("Q");

    private final String command;

    MainMenu(String command) {
        this.command = command;
    }

    public static MainMenu from(String input) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
