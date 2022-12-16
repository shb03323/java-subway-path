package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import java.util.stream.Collectors;

import static subway.view.MessagePrefix.ERROR_PREFIX;

public class SectionRepository {

    private static WeightedMultigraph<Station, DefaultWeightedEdge> lengthGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private static WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static void addStation(Station station) {
        lengthGraph.addVertex(station);
        timeGraph.addVertex(station);
    }

    public static void addSection(Station prevStation, Station nextStation, int length, int time) {
        lengthGraph.setEdgeWeight(lengthGraph.addEdge(prevStation, nextStation), length);
        timeGraph.setEdgeWeight(timeGraph.addEdge(prevStation, nextStation), time);
    }

    public static ResultDto findShortestLength(Station startStation, Station destinationStation) {
        validateSameStation(startStation, destinationStation);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(lengthGraph);
        List<Station> route =  dijkstraShortestPath.getPath(startStation, destinationStation).getVertexList();
        int routeLength = getRouteLength(route);
        int routeTime = getRouteTime(route);
        return new ResultDto(route.stream().collect(Collectors.toUnmodifiableList()), routeLength, routeTime);
    }

    private static int getRouteLength(List<Station> route) {
        int length = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            length += (int) lengthGraph.getEdgeWeight(lengthGraph.getEdge(route.get(i), route.get(i + 1)));
        }
        return length;
    }

    private static int getRouteTime(List<Station> route) {
        int time = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            time += (int) timeGraph.getEdgeWeight(timeGraph.getEdge(route.get(i), route.get(i + 1)));
        }
        return time;
    }

    private static void validateSameStation(Station startStation, Station destinationStation) {
        if (startStation.equals(destinationStation)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "출발역과 도착역이 동일합니다.");
        }
    }
}
