package es.urjc.code;

import es.urjc.code.dtos.FlightCodeCompanyDTO;
import es.urjc.code.dtos.MechanicNameSurnameDTO;
import es.urjc.code.dtos.PlaneMechanicDTO;
import es.urjc.code.dtos.PlaneMechanicsListDTO;
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
import java.util.*;

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
        Airport bcn = new Airport("BCN", "El prat", "Barcelona", "Spain");
        airportRepository.save(mad);
        airportRepository.save(muc);
        airportRepository.save(bcn);

        CrewMember c1 = new CrewMember("hy76rf", "John", "Smith", "Captain", "Lufthansa");
        CrewMember c2 = new CrewMember("uj87fn", "Jane", "Brown", "Co-pilot", "Lufthansa");
        crewMemberRepository.save(c1);
        crewMemberRepository.save(c2);

        Mechanic m1 = new Mechanic("hy76rf", "Peter", "Johnson", 2005, "Aeronautical Engineer");
        Mechanic m2 = new Mechanic("rt91lp", "Sandra", "Robbert", 2019, "Engineer");
        Mechanic m3 = new Mechanic("xc20ew", "Ellie", "Peterson", 2012, "Mechanic");
        mechanicRepository.save(m1);
        mechanicRepository.save(m2);
        mechanicRepository.save(m3);

        Flight f1 = new Flight("LH4323", "Lufthansa", p1, muc, mad, LocalDateTime.of(2016, Month.APRIL, 20, 06, 30), Duration.ofHours(2).plusMinutes(12));
        Flight f2 = new Flight("IB9851", "Iberia", p1, mad, muc, LocalDateTime.of(2016, Month.APRIL, 19, 06, 30), Duration.ofHours(2).plusMinutes(35));
        Flight f3 = new Flight("LH5892", "Lufthansa", p1, mad, muc, LocalDateTime.of(2016, Month.APRIL, 20, 12, 30), Duration.ofHours(2).plusMinutes(56));
        Flight f4 = new Flight("UX3633", "Air Europa", p1, bcn, muc, LocalDateTime.of(2016, Month.APRIL, 20, 18, 00), Duration.ofHours(1).plusMinutes(48));
        Flight f5 = new Flight("LH2564", "Lufthansa", p1, mad, muc, LocalDateTime.of(2016, Month.APRIL, 20, 07, 30), Duration.ofHours(2).plusMinutes(3));
        Flight f6 = new Flight("LH3855", "Lufthansa", p1, mad, muc, LocalDateTime.of(2016, Month.APRIL, 21, 06, 30), Duration.ofHours(2).plusMinutes(23));
        f1.setCrew(Arrays.asList(c1, c2));
        f2.setCrew(Arrays.asList(c1, c2));
        f3.setCrew(Arrays.asList(c1, c2));
        f4.setCrew(Arrays.asList(c1, c2));
        f5.setCrew(Arrays.asList(c1, c2));
        f6.setCrew(Arrays.asList(c1, c2));
        flightRepository.save(f1);
        flightRepository.save(f2);
        flightRepository.save(f3);
        flightRepository.save(f4);
        flightRepository.save(f5);
        flightRepository.save(f6);

        Review r1 = new Review(p1, LocalDate.of(2012, Month.FEBRUARY, 15), LocalDate.of(2012, Month.FEBRUARY, 17), Duration.ofHours(43), m1, "yearly review", "normal yearly review", muc);
        Review r2 = new Review(p2, LocalDate.of(2015, Month.MARCH, 8), LocalDate.of(2015, Month.MARCH, 12), Duration.ofHours(23), m2, "avionic review", "yearly avionic review", mad);
        Review r3 = new Review(p2, LocalDate.of(2018, Month.DECEMBER, 23), LocalDate.of(2018, Month.DECEMBER, 26), Duration.ofHours(12), m3, "landing review", "extra landing review", muc);
        Review r4 = new Review(p1, LocalDate.of(2019, Month.APRIL, 29), LocalDate.of(2019, Month.APRIL, 30), Duration.ofHours(5), m2, "avionic review", "yearly avionic review", mad);
        Review r5 = new Review(p1, LocalDate.of(2018, Month.JULY, 28), LocalDate.of(2018, Month.JULY, 31), Duration.ofHours(64), m1, "landing review", "extra landing review", muc);
        reviewRepository.save(r1);
        reviewRepository.save(r2);
        reviewRepository.save(r3);
        reviewRepository.save(r4);
        reviewRepository.save(r5);

        System.out.println("");
        System.out.println("Guardado completado");
        System.out.println("");

        // Recupera planes
        List<Plane> planes = planeRepository.findAll();
        System.out.println("Planes con findAll():");
        System.out.println("----------------------------------------");
        printData(planes);

        // Recupera aeropuertos
        List<Airport> airports = airportRepository.findAll();
        System.out.println("Airports con findAll():");
        System.out.println("----------------------------------------");
        printData(airports);

        // Recupera tripulantes
        List<CrewMember> crew = crewMemberRepository.findAll();
        System.out.println("Crew con findAll():");
        System.out.println("----------------------------------------");
        printData(crew);

        // Recupera mechanics
        List<Mechanic> mechanics = mechanicRepository.findAll();
        System.out.println("Mechanics con findAll():");
        System.out.println("----------------------------------------");
        printData(mechanics);

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









        // Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones.
        List<PlaneMechanicDTO> planesMechanic = reviewRepository.findPlaneMechanics();
        System.out.println("Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones:");
        System.out.println("----------------------------------------");
        Map<String, PlaneMechanicsListDTO> planeMechanicsListDTOS = new HashMap();

        planesMechanic.forEach((PlaneMechanicDTO planeMechanicDTO)-> {
            MechanicNameSurnameDTO mechanic = new MechanicNameSurnameDTO(planeMechanicDTO.getMechanicName(), planeMechanicDTO.getMechanicSurName());
            if (!planeMechanicsListDTOS.containsKey(planeMechanicDTO.getPlate())) {
                planeMechanicsListDTOS.put(planeMechanicDTO.getPlate(), new PlaneMechanicsListDTO(String.format("%s:%s - %s", planeMechanicDTO.getMaker(), planeMechanicDTO.getModel(), planeMechanicDTO.getPlate())));
            }
            planeMechanicsListDTOS.get(planeMechanicDTO.getPlate()).addMechanic(mechanic);
        });
        printData(planeMechanicsListDTOS);

        // Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.
        List<FlightCodeCompanyDTO> flightCodeCompanyDTOS = flightRepository.findFlightsLandedInCityAndDate("Munich", "2016-04-20");
        System.out.println("Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora:");
        System.out.println("----------------------------------------");
        printData(flightCodeCompanyDTOS);

    }


    private static void printData(List data) {
        for (Object p : data) {
            System.out.println(p);
        }
        System.out.println();
    }

    private static void printData(Map data) {
        for (Object p : data.values()) {
            System.out.println(p);
        }
        System.out.println();
    }

}
