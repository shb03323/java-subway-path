package subway.view;

import java.util.List;

import static subway.view.MessagePrefix.*;

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

    public static void printResultHeader() {
        System.out.println(OUTPUT_PREFIX + "조회 결과");
        System.out.println(INFO_PREFIX + PARTITION);
    }

    public static void printResultLength(int length) {
        System.out.println(INFO_PREFIX + "총 거리: " + length + "km");
    }

    public static void printResultTime(int time) {
        System.out.println(INFO_PREFIX + "총 소요 시간: " + time + "분");
        System.out.println(INFO_PREFIX + PARTITION);
    }

    public static void printResultRoute(List<String> stations) {
        stations.forEach(station -> System.out.println(INFO_PREFIX + station));
        System.out.println();
    }
}
