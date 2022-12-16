package subway.controller;

import subway.domain.*;

public class SubwayInitializer {

    public static void init() {
        initStation();
        initLine();
        initSection();
    }

    private static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private static void initSection() {
        initLineTwoSection(LineRepository.findByName("2호선"));
        initLineThreeSection(LineRepository.findByName("3호선"));
        initLineSinbundangSection(LineRepository.findByName("신분당선"));
    }

    private static void initLineTwoSection(Line line) {
        SectionRepository.addLine(line);
        Station gyodae = StationRepository.findByName("교대역");
        Station gangnam = StationRepository.findByName("강남역");
        Station yeoksam = StationRepository.findByName("역삼역");
        SectionRepository.addSection(line, gyodae, gangnam, 2, 3);
        SectionRepository.addSection(line, gangnam, yeoksam, 2, 3);
    }

    private static void initLineThreeSection(Line line) {
        SectionRepository.addLine(line);
        Station gyodae = StationRepository.findByName("교대역");
        Station nambuterminal = StationRepository.findByName("남부터미널역");
        Station yangjae = StationRepository.findByName("양재역");
        Station maebong = StationRepository.findByName("매봉역");
        SectionRepository.addSection(line, gyodae, nambuterminal, 3, 2);
        SectionRepository.addSection(line, nambuterminal, yangjae, 6, 5);
        SectionRepository.addSection(line, yangjae, maebong, 1, 1);
    }

    private static void initLineSinbundangSection(Line line) {
        SectionRepository.addLine(line);
        Station gangnam = StationRepository.findByName("강남역");
        Station yangjae = StationRepository.findByName("양재역");
        Station yangjaeCitizenForest = StationRepository.findByName("양재시민의숲역");
        SectionRepository.addSection(line, gangnam, yangjae, 2, 8);
        SectionRepository.addSection(line, yangjae, yangjaeCitizenForest, 10, 3);
    }
}
