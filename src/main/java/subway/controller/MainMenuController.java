package subway.controller;

import subway.domain.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class MainMenuController {

    private final Map<MainMenu, Controllable> controllers;

    public MainMenuController() {
        this.controllers = new EnumMap<>(MainMenu.class);
        initControllers();
    }

    public void run() {
        initSubway();
        OutputView.printMainMenu();
        MainMenu selection = selectMenu();
        while (!selection.equals(MainMenu.QUIT)) {
            progress(selection);
            OutputView.printMainMenu();
            selection = selectMenu();
        }
    }

    private void initControllers() {
        controllers.put(MainMenu.SEARCH_ROUTE, new SearchRouteController());
        controllers.put(MainMenu.QUIT, new QuitSystemController());
    }

    private void initSubway() {
        SubwayInitializer.init();
    }

    private MainMenu selectMenu() {
        try {
            String input = InputView.inputMenu();
            return MainMenu.from(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return selectMenu();
        }
    }

    private void progress(MainMenu selection) {
        controllers.get(selection).runMenu();
    }
}
