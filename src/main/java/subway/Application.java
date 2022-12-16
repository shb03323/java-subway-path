package subway;

import subway.controller.MainMenuController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.run();
    }
}
