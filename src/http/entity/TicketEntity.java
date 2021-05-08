package http.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Objects;

@Value
public class TicketEntity {

    Long id;
    String passengerNo;
    String passengerName;
    Long flightId;
    String seatNo;
    BigDecimal cost;


}
