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
        initSectionStations();
        initLineTwoSection();
        initLineThreeSection();
        initLineSinbundangSection();
    }

    private static void initSectionStations() {
        SectionRepository.addStation(StationRepository.findByName("교대역"));
        SectionRepository.addStation(StationRepository.findByName("강남역"));
        SectionRepository.addStation(StationRepository.findByName("역삼역"));
        SectionRepository.addStation(StationRepository.findByName("남부터미널역"));
        SectionRepository.addStation(StationRepository.findByName("양재역"));
        SectionRepository.addStation(StationRepository.findByName("양재시민의숲역"));
        SectionRepository.addStation(StationRepository.findByName("매봉역"));
    }

    private static void initLineTwoSection() {
        Station gyodae = StationRepository.findByName("교대역");
        Station gangnam = StationRepository.findByName("강남역");
        Station yeoksam = StationRepository.findByName("역삼역");
        SectionRepository.addSection(gyodae, gangnam, 2, 3);
        SectionRepository.addSection(gangnam, yeoksam, 2, 3);
    }

    private static void initLineThreeSection() {
        Station gyodae = StationRepository.findByName("교대역");
        Station nambuterminal = StationRepository.findByName("남부터미널역");
        Station yangjae = StationRepository.findByName("양재역");
        Station maebong = StationRepository.findByName("매봉역");
        SectionRepository.addSection(gyodae, nambuterminal, 3, 2);
        SectionRepository.addSection(nambuterminal, yangjae, 6, 5);
        SectionRepository.addSection(yangjae, maebong, 1, 1);
    }

    private static void initLineSinbundangSection() {
        Station gangnam = StationRepository.findByName("강남역");
        Station yangjae = StationRepository.findByName("양재역");
        Station yangjaeCitizenForest = StationRepository.findByName("양재시민의숲역");
        SectionRepository.addSection(gangnam, yangjae, 2, 8);
        SectionRepository.addSection(yangjae, yangjaeCitizenForest, 10, 3);
    }
}
