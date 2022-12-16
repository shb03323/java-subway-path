package subway.domain;

import java.util.Arrays;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public enum RouteSearchMenu {

    SHORTEST_LENGTH("1"),
    SHORTEST_TIME("2"),
    BACK("B");

    private final String command;

    RouteSearchMenu(String command) {
        this.command = command;
    }

    public static RouteSearchMenu from(String input) {
        return Arrays.stream(RouteSearchMenu.values())
                .filter(routeSearchMenu -> routeSearchMenu.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
