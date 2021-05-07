package http.service;

import http.dao.FlightDao;
import http.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService(){
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(entityFlight -> new FlightDto(
                        entityFlight.getId(),
                        """
                                %s - %s - %s
                                """.formatted(entityFlight.getDepartureAirportCode(), entityFlight.getArrivalAirportCode(), entityFlight.getStatus())
                ))
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
