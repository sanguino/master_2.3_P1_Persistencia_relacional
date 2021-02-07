package es.urjc.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import es.urjc.code.entities.Airport;
import es.urjc.code.entities.CrewMember;
import es.urjc.code.entities.Plane;
import es.urjc.code.repositories.AirportRepository;
import es.urjc.code.repositories.CrewMemberRepository;
import es.urjc.code.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

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

    @Override
    public void run(String... args) throws ParseException {

        // Guardando datos ...
        Plane p1 = new Plane("EC-FGE", "Airbus", "A320", Duration.ofHours(1452));
        Plane p2 = new Plane("EC-UEF", "Boeing", "747", Duration.ofHours(3452));
        planeRepository.save(p1);
        planeRepository.save(p2);

        Airport a1 = new Airport("MAD", "Barajas", "Madrid", "Spain");
        Airport a2 = new Airport("MUC", "Munich Airport", "Munich", "Germany");
        airportRepository.save(a1);
        airportRepository.save(a2);

        CrewMember c1 = new CrewMember("hy76rf", "Jonh", "Smith", "Captain", "Lufthansa");
        CrewMember c2 = new CrewMember("uj87fn", "Jane", "Brown", "Co-pilot", "Lufthansa");
        crewMemberRepository.save(c1);
        crewMemberRepository.save(c2);

        // Recupera aviones
        List<Plane> planes = planeRepository.findAll();
        System.out.println("Planes con findAll():");
        System.out.println("----------------------------------------");
        printData(planes);


    }


    private static void printData(List data) {
        for (Object p : data) {
            System.out.println(p);
        }
        System.out.println();
    }

}
