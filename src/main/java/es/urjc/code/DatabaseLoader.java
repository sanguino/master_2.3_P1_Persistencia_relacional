package es.urjc.code;

import es.urjc.code.entities.*;
import es.urjc.code.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author Miguel G. Sanguino
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private PlaneRepository planeRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CrewMemberRepository crewMemberRepository;

    @Autowired
    private MechanicRepository mechanicRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws ParseException {

        // Guardando datos ...
        Plane p1 = new Plane("EC-FGE", "Airbus", "A320", Duration.ofHours(1452));
        Plane p2 = new Plane("EC-UEF", "Boeing", "747", Duration.ofHours(3452));
        planeRepository.save(p1);
        planeRepository.save(p2);

        Airport mad = new Airport("MAD", "Barajas", "Madrid", "Spain");
        Airport muc = new Airport("MUC", "Franz Josef Strauss", "Munich", "Germany");
        airportRepository.save(mad);
        airportRepository.save(muc);

        CrewMember c1 = new CrewMember("hy76rf", "John", "Smith", "Captain", "Lufthansa");
        CrewMember c2 = new CrewMember("uj87fn", "Jane", "Brown", "Co-pilot", "Lufthansa");
        crewMemberRepository.save(c1);
        crewMemberRepository.save(c2);

        Mechanic m1 = new Mechanic("hy76rf", "Peter", "Johnson", 2005, "Aeronautical Engineer");
        mechanicRepository.save(m1);

        Flight f1 = new Flight("LH9851", " Lufthansa ", p1, mad, muc, LocalDateTime.of(2016, Month.APRIL, 20, 06, 30), Duration.ofHours(2).plusMinutes(35));
        f1.setCrew(Arrays.asList(c1, c2));
        flightRepository.save(f1);

        Review r1 = new Review(p1, LocalDate.of(2015, Month.FEBRUARY, 15), LocalDate.of(2015, Month.FEBRUARY, 12), Duration.ofHours(43), m1, "year review", "normal tear review", muc);
        reviewRepository.save(r1);

        System.out.println("");
        System.out.println("Guardado completado");
        System.out.println("");

        // Recupera aviones
        List<Plane> planes = planeRepository.findAll();
        System.out.println("Planes con findAll():");
        System.out.println("----------------------------------------");
        printData(planes);

        // Recupera vuelos
        List<Flight> flights = flightRepository.findAll();
        System.out.println("Flights con findAll():");
        System.out.println("----------------------------------------");
        printData(flights);

        // Recupera reviews
        List<Review> reviews = reviewRepository.findAll();
        System.out.println("Reviews con findAll():");
        System.out.println("----------------------------------------");
        printData(reviews);
    }


    private static void printData(List data) {
        for (Object p : data) {
            System.out.println(p);
        }
        System.out.println();
    }

}
