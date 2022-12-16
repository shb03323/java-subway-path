package subway.domain;

public class Section {

    private final Station prevStation;
    private final Station nextStation;
    private final int sectionLength;
    private final int sectionTime;

    public Section(Station prevStation, Station nextStation, int sectionLength, int sectionTime) {
        this.prevStation = prevStation;
        this.nextStation = nextStation;
        this.sectionLength = sectionLength;
        this.sectionTime = sectionTime;
    }

    public int getSectionLength() {
        return sectionLength;
    }

    public int getSectionTime() {
        return sectionTime;
    }
}
