package http.service;

import http.dao.TicketDao;
import http.dto.TicketDto;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor
public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlight(flightId).stream()
                .map(ticketDao -> TicketDto.builder()
                        .id(ticketDao.getId())
                        .flightId(ticketDao.getFlightId())
                        .seatNo(ticketDao.getSeatNo())
                        .build()
                )
                .collect(toList());
    }

    public static TicketService getINSTANCE() {
        return INSTANCE;
    }

}
