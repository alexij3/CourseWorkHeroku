package com.buzilov.lab6crud.datastorage;

import com.buzilov.lab6crud.model.*;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DataStorageFake {
    /*public List<Artist> artists = new ArrayList<>(
            Arrays.asList(
                    new Artist(1, "Бойчук Олег Станіславович"),
                    new Artist(2, "Стецько Анастасія Петрівна"),
                    new Artist(3, "Дубовик Юрій Іванович"),
                    new Artist(4, "Самойлов Петро Андрійович"),
                    new Artist(5, "Гак Марина Миколаївна"),
                    new Artist(6, "Моршин Катерина Петрівна"),
                    new Artist(7, "Ступка Богдан Богданович"),
                    new Artist (8, "Антимійчук Микола Павлович"),
                    new Artist(9, "Блажчук Максим Олександрович"),
                    new Artist(10, "Бордюжан Борис Борисович"),
                    new Artist(11, "Сом Артур Миколайович"),
                    new Artist(12, "Дашкевич Каріна Андріївна"),
                    new Artist(13, "Блажчук Павло Олександрович"),
                    new Artist(14, "Остапенко Дмитро Васильович"),
                    new Artist(15, "Романенко Владислав Романович"),
                    new Artist(16, "Бундурчук Микола Андрійович"),
                    new Artist(17, "Симоненко Василь Сергійович"),
                    new Artist(18, "Баст Леонід Вікторович"),
                    new Artist(19, "Слон Максим Євгенійович")
            )
    );*/

    public Genre genres;

    /*public List<Artist> artists = new ArrayList<>(
            Arrays.asList(
                    new Artist(1, "Бойчук Олег Станіславович",
                            Set.of(Genre.Комедія, Genre.Боєвик, Genre.Фантастика)),
                    new Artist(2, "Стецько Анастасія Петрівна",
                            Set.of(Genre.Фентезі, Genre.Тріллер, Genre.Детектив)),
                    new Artist(3, "Дубовик Юрій Іванович",
                            Set.of(Genre.Фантастика, Genre.Боєвик, Genre.Фентезі)),
                    new Artist(4, "Самойлов Петро Андрійович",
                            Set.of(Genre.Фантастика, Genre.Фентезі, Genre.Тріллер)),
                    new Artist(5, "Гак Марина Миколаївна",
                            Set.of(Genre.Фантастика, Genre.Тріллер, Genre.Детектив)),
                    new Artist(6, "Моршин Катерина Петрівна",
                            Set.of(Genre.Комедія, Genre.Драма, Genre.Мелодрама)),
                    new Artist(7, "Ступка Богдан Богданович",
                            Set.of(Genre.Мюзикл, Genre.Пародія)),
                    new Artist (8, "Антимійчук Микола Павлович",
                            Set.of(Genre.Комедія)),
                    new Artist(9, "Блажчук Максим Олександрович",
                            Set.of(Genre.Тріо)),
                    new Artist(10, "Бордюжан Борис Борисович",
                            Set.of(Genre.Квартет)),
                    new Artist(11, "Сом Артур Миколайович",
                            Set.of(Genre.Симфонія, Genre.Соната)),
                    new Artist(12, "Дашкевич Каріна Андріївна",
                            Set.of(Genre.Натюрморт, Genre.Портрет, Genre.Пейзаж, Genre.Різьблення)),
                    new Artist(13, "Блажчук Павло Олександрович",
                            Set.of(Genre.Портрет, Genre.Пейзаж, Genre.Скульптура, Genre.Різьблення)),
                    new Artist(14, "Остапенко Дмитро Васильович",
                            Set.of(Genre.Портрет, Genre.Різьблення)),
                    new Artist(15, "Романенко Владислав Романович",
                            Set.of(Genre.Портрет, Genre.Різьблення)),
                    new Artist(16, "Бундурчук Микола Андрійович",
                            Set.of(Genre.Натюрморт, Genre.Портрет, Genre.Пейзаж, Genre.Скульптура, Genre.Різьблення)),
                    new Artist(17, "Симоненко Василь Сергійович",
                            Set.of(Genre.Натюрморт, Genre.Портрет, Genre.Пейзаж, Genre.Скульптура, Genre.Різьблення)),
                    new Artist(18, "Баст Леонід Вікторович",
                            Set.of(Genre.Натюрморт, Genre.Портрет, Genre.Пейзаж, Genre.Скульптура, Genre.Різьблення)),
                    new Artist(19, "Слон Максим Євгенійович",
                            Set.of(Genre.Натюрморт, Genre.Портрет, Genre.Пейзаж, Genre.Скульптура, Genre.Різьблення))
            )
    );*/


    public List<Impresario> impresarios = new ArrayList<>(
            /*Arrays.asList(
                    new Impresario(1, "Бабенко Петро Михайлович",
                            Set.of(Genre.Комедія, Genre.Драма,Genre.Фантастика)),
                    new Impresario(2, "Димитрук Світлана Вікторівна",
                            Set.of(Genre.Драма, Genre.Мелодрама, Genre.Мюзикл)),
                    new Impresario(3, "Ягоненко Микола Іванович",
                            Set.of(Genre.Фантастика, Genre.Боєвик)),
                    new Impresario(4, "Дрінь Ярослав Михайлович",
                            Set.of(Genre.Фентезі, Genre.Тріллер)),
                    new Impresario(5, "Столяр Іван Андрійович",
                            Set.of(Genre.Комедія, Genre.Детектив)),
                    new Impresario(6, "Мур Дмитро Павлович",
                            Set.of(Genre.Мелодрама, Genre.Пародія, Genre.Мюзикл, Genre.Симфонія))

            )*/
    );

    /*public List<ArtistAndImpresario> artistAndImpresarios = new ArrayList<>(
            Arrays.asList(
                    new ArtistAndImpresario(artists.get(0), impresarios.get(0)),
                    new ArtistAndImpresario(artists.get(0), impresarios.get(1)),
                    new ArtistAndImpresario(artists.get(1), impresarios.get(3)),
                    new ArtistAndImpresario(artists.get(1), impresarios.get(4)),
                    new ArtistAndImpresario(artists.get(2), impresarios.get(0)),
                    new ArtistAndImpresario(artists.get(2), impresarios.get(2)),
                    new ArtistAndImpresario(artists.get(2), impresarios.get(3)),
                    new ArtistAndImpresario(artists.get(5), impresarios.get(5))
            )
    );*/

    public List<Cinema> cinemas = new ArrayList<>(
            Arrays.asList(
                    new Cinema(1, "Кінотеатр \"Парасолька\"", "вул. Перша 1", 100),
                    new Cinema(2, "Кінопалац \"Великий\"", "вул. Друга 2", 120),
                    new Cinema(3, "Кінотеатр \"Мудрець\"", "вул. Третя 3", 130),
                    new Cinema(4, "Кінотеатр \"Ум\"", "вул. Четверта 4", 120),
                    new Cinema(5, "Кінотеатр \"Стандарт\"", "вул. П'ята 5", 115),
                    new Cinema(6, "Кінотеатр \"Преміум\"", "вул. Шоста 6", 150),
                    new Cinema(7, "Кінотеатр \"Де-Люкс\"", "вул. Сьома 7", 200),
                    new Cinema(8, "Кінотеатр \"Домашній\"", "площа Перша 1", 140),
                    new Cinema(9, "Кінотеатр \"Міський\"", "площа Друга 2", 160),
                    new Cinema(10, "Кінопалац \"Малий\"", "площа Третя 3", 170)
            )
    );

    public List<CinemaMovie> cinemaMovies = new ArrayList<>(
            /*Arrays.asList(
                    new CinemaMovie(1, "Перший фільм", "Комедія", cinemas.get(0), new Date(2018-14-01)),
                    new CinemaMovie(2, "Другий фільм", "Комедія", cinemas.get(1), new Date(2017-12-27)),
                    new CinemaMovie(3, "Третій фільм", "Боєвик", cinemas.get(2), new Date(2018-03-04)),
                    new CinemaMovie(4, "Четвертий фільм", "Фантастика", cinemas.get(3), new Date(2018-02-18)),
                    new CinemaMovie(5, "П'ятий фільм", "Детектив", cinemas.get(4), new Date(2018-02-21)),
                    new CinemaMovie(6, "Шостий фільм", "Тріллер", cinemas.get(5), new Date(2018-02-25)),
                    new CinemaMovie(7, "Сьомий фільм", "Детектив", cinemas.get(6), new Date(2018-02-23)),
                    new CinemaMovie(8, "Восьмий фільм", "Фантастика", cinemas.get(7), new Date(2018-02-27)),
                    new CinemaMovie(9, "Дев'ятий фільм", "Комедія", cinemas.get(8), new Date(2018-02-10)),
                    new CinemaMovie(10, "Десятий фільм", "Драма", cinemas.get(9), new Date(2018-02-15))
            )*/
    );

    public List<ConcertHall> concertHalls = new ArrayList<>(
            Arrays.asList(
                    new ConcertHall(1, "Майданчик \"Перший\"", "вул. Майданчиків 1", 60),
                    new ConcertHall(2, "Майданчик \"Другий\"", "вул. Майданчиків 2", 70),
                    new ConcertHall(3, "Майданчик \"Третій\"", "вул. Майданчиків 3", 80),
                    new ConcertHall(4, "Майданчик \"Четвертий\"", "вул. Майданчиків 4", 90),
                    new ConcertHall(5, "Майданчик \"П'ятий\"", "вул. Майданчиків 5", 100),
                    new ConcertHall(6, "Майданчик \"Шостий\"", "вул. Майданчиків 6", 110),
                    new ConcertHall(7, "Майданчик \"Сьомий\"", "вул. Майданчиків 7", 50),
                    new ConcertHall(8, "Майданчик \"Восьмий\"", "вул. Майданчиків 8", 60),
                    new ConcertHall(9, "Майданчик \"Дев'ятий\"", "вул. Майданчиків 8", 70),
                    new ConcertHall(10, "Майданчик \"Десятий\"", "вул. Майданчиків 9", 80)
            )
    );

    public List<Organizer> organizers = new ArrayList<>(
            Arrays.asList(
                    new Organizer(1, "Нестійко Марина Василівна"),
                    new Organizer(2, "Марик Степан Васильович"),
                    new Organizer(3, "Гринюк Денис Денисович"),
                    new Organizer(4, "Деранчук Станіслав Ігоревич"),
                    new Organizer(5, "Ігорчук Ігор Ігоревич"),
                    new Organizer(6, "Стопанко Андрій Андрійович"),
                    new Organizer(7, "Павленко Степан Павлович"),
                    new Organizer(8, "Блунчук Лариса Іванівна"),
                    new Organizer(9, "Торба Олексій Валентинович"),
                    new Organizer(10, "Жаба Микола Андрійович"),
                    new Organizer(11, "Санта Марія Григоріївна"),
                    new Organizer(12, "Дмитриченко Ксенія Леонідівна"),
                    new Organizer(13, "Дунай Григорій Васильович"),
                    new Organizer(14, "Мельничук Євген Євгенійович"),
                    new Organizer(15, "Охотник Олег Олегович")
            )
    );

    public List<ConcertInHall> concertsInHall = new ArrayList<>(
           /* Arrays.asList(
                    new ConcertInHall(1, concertHalls.get(0), "Концерт №1", organizers.get(0), new Date(2018-02-01)),
                    new ConcertInHall(2, concertHalls.get(0), "Концерт №2", organizers.get(1), new Date(2018-02-03)),
                    new ConcertInHall(3, concertHalls.get(0), "Концерт №3", organizers.get(2), new Date(2018-02-04)),
                    new ConcertInHall(4, concertHalls.get(1), "Концерт №4", organizers.get(3), new Date(2018-02-06)),
                    new ConcertInHall(5, concertHalls.get(1), "Концерт №5", organizers.get(4), new Date(2018-02-10)),
                    new ConcertInHall(6, concertHalls.get(2), "Концерт №6", organizers.get(5), new Date(2018-02-12)),
                    new ConcertInHall(7, concertHalls.get(2), "Концерт №7", organizers.get(6), new Date(2018-02-14)),
                    new ConcertInHall(8, concertHalls.get(3), "Концерт №8", organizers.get(7), new Date(2018-02-15)),
                    new ConcertInHall(9, concertHalls.get(3), "Концерт №9", organizers.get(8), new Date(2018-02-18)),
                    new ConcertInHall(10, concertHalls.get(4), "Концерт №10", organizers.get(9), new Date(2018-02-21)),
                    new ConcertInHall(11, concertHalls.get(4), "Концерт №11", organizers.get(10), new Date(2018-02-23)),
                    new ConcertInHall(12, concertHalls.get(5), "Концерт №12", organizers.get(11), new Date(2018-02-23)),
                    new ConcertInHall(13, concertHalls.get(6), "Концерт №13", organizers.get(12), new Date(2018-02-24)),
                    new ConcertInHall(14, concertHalls.get(7), "Концерт №14", organizers.get(13), new Date(2018-02-25)),
                    new ConcertInHall(15, concertHalls.get(8), "Концерт №15", organizers.get(14), new Date(2018-02-27)),
                    new ConcertInHall(16, concertHalls.get(9), "Концерт №16", organizers.get(0), new Date(2018-02-27))
            )*/
    );

    public List<CulturePalace> culturePalaces = new ArrayList<>(
            Arrays.asList(
                    new CulturePalace(1, "Палац \"Диво\"", "вул. Палаців 1", 60),
                    new CulturePalace(2, "Палац \"Диво\"", "вул. Палаців 2", 70),
                    new CulturePalace(3, "Палац \"Неймовірний\"", "вул. Палаців 3", 60),
                    new CulturePalace(4, "Палац \"Чудовий\"", "вул. Палаців 4", 50),
                    new CulturePalace(5, "Палац \"Фантазія\"", "вул. Палаців 5", 70),
                    new CulturePalace(6, "Культурний центр \"Магія\"", "вул. Палаців 6", 120),
                    new CulturePalace(7, "Культурний центр \"Історичний\"", "вул. Палаців 7", 60),
                    new CulturePalace(8, "Палац \"Стрибок у минуле\"", "вул. Палаців 8", 90),
                    new CulturePalace(9, "Культурний центр \"Мальовничий\"", "вул. Палаців 9", 70),
                    new CulturePalace(10, "Палац \"Одинокий\"", "вул. Палаців 10", 60)
            )
    );

    public List<ContestInPalace> contestsInPalaces = new ArrayList<>(
           /* Arrays.asList(
                    new ContestInPalace(1, culturePalaces.get(0), "Конкурс-виставка \"Натюрморт\"", organizers.get(0), new Date(2018-01-20)),
                    new ContestInPalace(2, culturePalaces.get(0), "Конкурс-виставка \"Різьблення\"", organizers.get(1), new Date(2018-01-25)),
                    new ContestInPalace(3, culturePalaces.get(0), "Конкурс \"Портрет\"", organizers.get(2), new Date(2018-02-01)),
                    new ContestInPalace(4, culturePalaces.get(2), "Конкурс \"Пейзаж\"", organizers.get(3), new Date(2018-02-05)),
                    new ContestInPalace(5, culturePalaces.get(4), "Конкурс \"Диво-історія\"", organizers.get(4), new Date(2018-02-10)),
                    new ContestInPalace(6, culturePalaces.get(5), "Конкурс \"Інший\"", organizers.get(5), new Date(2018-01-14)),
                    new ContestInPalace(7, culturePalaces.get(6), "Конкурс \"Багатий\"", organizers.get(6), new Date(2018-03-02))
            )*/
    );

    /*public List<ContestResults> contestResults = new ArrayList<>(
            Arrays.asList(
                    new ContestResults(contestsInPalaces.get(0), artists.get(11), 1, 'Y'),
                    new ContestResults(contestsInPalaces.get(0), artists.get(15), 2, 'Y'),
                    new ContestResults(contestsInPalaces.get(0), artists.get(16), 3, 'Y'),
                    new ContestResults(contestsInPalaces.get(0), artists.get(17), 4, 'N'),
                    new ContestResults(contestsInPalaces.get(0), artists.get(18), 5, 'N')
            )
    );*/


    public List<Theatre> theatres = new ArrayList<>(
            Arrays.asList(
                    new Theatre(1, "Театр \"Кобила\"", "площа Театральна 1", 50),
                    new Theatre(2, "Театр \"Класний\"", "площа Театральна 1", 50),
                    new Theatre(3, "Театр \"Класичний\"", "площа Театральна 1", 60),
                    new Theatre(4, "Театр \"Лісовик\"", "площа Театральна 2", 70),
                    new Theatre(5, "Театр \"Дивовижа\"", "площа Театральна 3", 80),
                    new Theatre(6, "Театр \"Ластівка\"", "площа Театральна 4", 90),
                    new Theatre(7, "Театр \"Гром\"", "площа Театральна 5", 100),
                    new Theatre(8, "Театр \"Молнія\"", "площа Театральна 6", 90),
                    new Theatre(9, "Театр \"Вогонь\"", "площа Театральна 7", 80),
                    new Theatre(10, "Театр \"На крихті льоду\"", "площа Театральна 8", 70)
            )
    );

    public List<TheatrePerformance> theatrePerformances = new ArrayList<>(
           /* Arrays.asList(
                new TheatrePerformance(1, "Перший виступ", theatres.get(0), organizers.get(0), new Date(2018-02-14)),
                new TheatrePerformance(2, "Другий виступ", theatres.get(1), organizers.get(0), new Date(2018-01-27)),
                new TheatrePerformance(3, "Третій виступ", theatres.get(2), organizers.get(1), new Date(2018-02-04)),
                new TheatrePerformance(4, "Четвертий виступ", theatres.get(3), organizers.get(2), new Date(2018-02-07)),
                new TheatrePerformance(5, "П'ятий виступ", theatres.get(4), organizers.get(3), new Date(2018-01-23)),
                new TheatrePerformance(6, "Шостий виступ", theatres.get(5), organizers.get(4), new Date(2018-03-02)),
                new TheatrePerformance(7, "Сьомий виступ", theatres.get(6), organizers.get(5), new Date(2018-03-03)),
                new TheatrePerformance(8, "Восьмий виступ", theatres.get(7), organizers.get(6), new Date(2018-03-04))
            )*/
    );

    public List<TheatrePerformance> getTheatrePerformances() {
        return theatrePerformances;
    }

    public List<ContestInPalace> getContestsInPalaces() {
        return contestsInPalaces;
    }

    public List<ContestResults> getContestResults() {
        return null;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public List<CulturePalace> getCulturePalaces() {
        return culturePalaces;
    }

    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public List<ConcertInHall> getConcertsInHall() {
        return concertsInHall;
    }

    public List<CinemaMovie> getCinemaMovies() {
        return cinemaMovies;
    }

    public List<ConcertHall> getConcertHalls() {
        return concertHalls;
    }

    public Genre getGenres() {
        return genres;
    }

    public List<Artist> getArtists() {
        return null;
    }
    public List<Impresario> getImpresarios() {
        return impresarios;
    }
    public List<ArtistAndImpresario> getArtistAndImpresarios() {
        return null;
    }
    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
