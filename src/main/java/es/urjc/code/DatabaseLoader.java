package es.urjc.code;

import es.urjc.code.dtos.*;
import es.urjc.code.entities.*;
import es.urjc.code.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Cargador de la BD, ejemplos de consulta y consultas de la practica.
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

    @Autowired
    private FlightCrewRepository flightCrewRepository;

    @Override
    public void run(String... args) throws ParseException {

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

        planesMechanic.forEach((PlaneMechanicDTO planeMechanicDTO) -> {
            MechanicNameSurnameDTO mechanic = new MechanicNameSurnameDTO(planeMechanicDTO.getMechanicName(), planeMechanicDTO.getMechanicSurName());
            if (!planeMechanicsListDTOS.containsKey(planeMechanicDTO.getPlate())) {
                planeMechanicsListDTOS.put(planeMechanicDTO.getPlate(), new PlaneMechanicsListDTO(String.format("%s:%s - %s", planeMechanicDTO.getMaker(), planeMechanicDTO.getModel(), planeMechanicDTO.getPlate())));
            }
            planeMechanicsListDTOS.get(planeMechanicDTO.getPlate()).addMechanic(mechanic);
        });
        printData(planeMechanicsListDTOS);


        // P1: Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.
        List<FlightCodeCompanyDTO> flightCodeCompanyDTOS = flightRepository.findFlightsLandedInCityAndDate("Munich", "2016-04-20");
        System.out.println("P1: Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora:");
        System.out.println("----------------------------------------");
        printData(flightCodeCompanyDTOS);


        // P1: Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las ciudades desde las que ha despegado junto con la fecha en que despegó.
        CrewMember crewUJ87FN = crewMemberRepository.findTopByCode("uj87fn");
        System.out.println("P1: Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las ciudades desde las que ha despegado junto con la fecha en que despegó:");
        System.out.println("----------------------------------------");
        CrewCitiesDTO crewCitiesDTO = new CrewCitiesDTO(crewUJ87FN.getCode(), crewUJ87FN.getFlights());
        printData(crewCitiesDTO);

        // P1: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos.
        List<CrewFlightsDTO> crewFlightsDTOS = crewMemberRepository.findAllFlightsAndDuration();
        System.out.println("P1: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos:");
        System.out.println("----------------------------------------");
        printData(crewFlightsDTOS);

        // P2: Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones.
        List<MechanicsOfPlaneInterface> mechanicsOfPlaneInterfaces = planeRepository.findAllMechanicsOfaPlane();
        System.out.println("P2: Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones:");
        System.out.println("----------------------------------------");
        List<MechanicsOfPlaneDTO> mechanicsOfPlaneDTOS = mechanicsOfPlaneInterfaces.stream().map(i -> new MechanicsOfPlaneDTO(i.getPlate(), i.getName(), i.getSurName())).collect(Collectors.toList());
        printData(mechanicsOfPlaneDTOS);

        // P2: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos.
        List<CrewFlightsInterface> crewFlightsInterfaces = crewMemberRepository.findAllFlightsAndDurationJSON();
        System.out.println("P2: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos:");
        System.out.println("----------------------------------------");
        List<CrewFlightsDTO> crewFlightsDTOSJSON = crewFlightsInterfaces.stream().map(i -> new CrewFlightsDTO(i.getName(), i.getSurName(), i.getFlightsTotal(), i.getDurationTotal())).collect(Collectors.toList());
        printData(crewFlightsDTOSJSON);
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

    private static void printData(Object data) {
        System.out.println(data);
        System.out.println();
    }

}
