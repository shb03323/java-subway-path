package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionRepository {

    private static final Map<Line, List<Section>> sections = new HashMap<>();

    public static void addLine(Line line) {
        sections.put(line, new ArrayList<>());
    }

    public static void addSection(Line line, Station prevStation, Station nextStation, int length, int time) {
        Section section = new Section(prevStation, nextStation, length, time);
        sections.get(line).add(section);
    }


}
