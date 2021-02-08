package es.urjc.code.dtos;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Miguel G. Sanguino
 */
public class FlightCodeCompanyDTO {

    private String code;

    private String company;

    private LocalDateTime landing;

    public FlightCodeCompanyDTO() {
    }

    public FlightCodeCompanyDTO(String code, String company, LocalDateTime departure, int duration) {
        this.code = code;
        this.company = company;
        this.landing = departure.plus(Duration.ofMinutes(duration));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getLanding() {
        return landing;
    }

    public void setLanding(LocalDateTime landing) {
        this.landing = landing;
    }

    @Override
    public String toString() {
        return "FlightCodeCompanyDTO{" +
                "code='" + code + '\'' +
                ", company='" + company + '\'' +
                ", landing=" + landing.getHour() + "h " + landing.getMinute() + "m" +
                '}';
    }
}