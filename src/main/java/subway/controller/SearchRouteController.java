package subway.controller;

import subway.domain.ResultDto;
import subway.domain.RouteSearchMenu;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class SearchRouteController implements Controllable {

    private final Map<RouteSearchMenu, Runnable> routeSearchRunOptions;

    public SearchRouteController() {
        this.routeSearchRunOptions = new EnumMap<>(RouteSearchMenu.class);
        initOptions();
    }

    @Override
    public void runMenu() {
        try {
            OutputView.printRouteSearchMenu();
            RouteSearchMenu selection = selectMenu();
            progress(selection);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            runMenu();
        }
    }

    private void initOptions() {
        routeSearchRunOptions.put(RouteSearchMenu.SHORTEST_LENGTH, SearchRouteController::searchShortestLength);
        routeSearchRunOptions.put(RouteSearchMenu.SHORTEST_TIME, SearchRouteController::searchShortestTime);
        routeSearchRunOptions.put(RouteSearchMenu.BACK, SearchRouteController::goBack);
    }

    private RouteSearchMenu selectMenu() {
        String command = InputView.inputMenu();
        return RouteSearchMenu.from(command);
    }

    private void progress(RouteSearchMenu routeSearchMenu) {
        routeSearchRunOptions.get(routeSearchMenu).run();
    }

    private static void searchShortestLength() {
        String startStationName = InputView.inputStartStation();
        Station startStation = StationRepository.findByName(startStationName);
        String destinationStationName = InputView.inputDestinationStation();
        Station destinationStation = StationRepository.findByName(destinationStationName);
        ResultDto result = SectionRepository.findShortestLength(startStation, destinationStation);
        showResult(result);
    }

    private static void searchShortestTime() {
        String startStationName = InputView.inputStartStation();
        Station startStation = StationRepository.findByName(startStationName);
        String destinationStationName = InputView.inputDestinationStation();
        Station destinationStation = StationRepository.findByName(destinationStationName);
        ResultDto result = SectionRepository.findShortestTime(startStation, destinationStation);
        showResult(result);
    }

    private static void goBack() {}

    private static void showResult(ResultDto result) {
        OutputView.printResultHeader();
        OutputView.printResultLength(result.getRouteLength());
        OutputView.printResultTime(result.getRouteTime());
        OutputView.printResultRoute(result.getRoute());
    }
}
