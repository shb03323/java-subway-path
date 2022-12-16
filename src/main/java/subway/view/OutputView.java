package subway.view;

import static subway.view.MessagePrefix.OUTPUT_PREFIX;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(message + "\n");
    }

    public static void printMainMenu() {
        System.out.println(OUTPUT_PREFIX + "메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료\n");
    }

    public static void printRouteSearchMenu() {
        System.out.println(OUTPUT_PREFIX + "경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기\n");
    }
}
