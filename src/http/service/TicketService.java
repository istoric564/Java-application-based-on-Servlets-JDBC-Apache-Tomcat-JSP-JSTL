package http.service;

import http.dao.TicketDao;
import http.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService(){
    }

    public List<TicketDto> findAllByFlightId(Long flightId){
        return ticketDao.findAllByFlight(flightId).stream()
                .map(ticketDao -> new TicketDto(
                        ticketDao.getId(),
                        ticketDao.getFlightId(),
                        ticketDao.getSeatNo()
                ))
                .collect(toList());
    }

    public static TicketService getINSTANCE() {
        return INSTANCE;
    }

}
