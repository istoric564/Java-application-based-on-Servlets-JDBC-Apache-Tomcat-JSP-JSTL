package http.service;

import http.dao.FlightDao;
import http.dto.FlightDto;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;



@NoArgsConstructor
public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();


    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(entityFlight -> FlightDto.builder()
                        .id(entityFlight.getId())
                        .description(
                                """
                                        %s - %s - %s
                                        """.formatted(
                                        entityFlight.getDepartureAirportCode(),
                                        entityFlight.getArrivalAirportCode(),
                                        entityFlight.getStatus()))
                        .build()
                )
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
