package subway.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ResultDto {

    private final List<Station> stations;
    private final int routeLength;
    private final int routeTime;

    public ResultDto(List<Station> stations, int routeLength, int routeTime) {
        this.stations = stations;
        this.routeLength = routeLength;
        this.routeTime = routeTime;
    }

    public int getRouteLength() {
        return routeLength;
    }

    public int getRouteTime() {
        return routeTime;
    }

    public List<String> getRoute() {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
