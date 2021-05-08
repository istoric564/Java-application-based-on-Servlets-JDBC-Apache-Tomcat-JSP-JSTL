package http.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Objects;

@Value
public class entityFlight {
    Long id;
    String flightNo;
    LocalDateTime departureDate;
    String departureAirportCode;
    LocalDateTime arrivalDate;
    String arrivalAirportCode;
    Integer aircraftId;
    FlightStatus status;
}
