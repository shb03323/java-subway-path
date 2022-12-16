package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

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

    public static void findShortestLength(Station startStation, Station destinationStation) {

    }
}
