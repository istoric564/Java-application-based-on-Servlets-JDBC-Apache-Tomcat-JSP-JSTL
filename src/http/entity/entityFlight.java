package http.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class entityFlight {
    private Long id;
    private String flightNo;
    private LocalDateTime departureDate;
    private String departureAirportCode;
    private LocalDateTime arrivalDate;
    private String arrivalAirportCode;
    private Integer aircraftId;
    private FlightStatus status;

    public entityFlight(Long id, String flightNo, LocalDateTime departureDate, String departureAirportCode, LocalDateTime arrivalDate, String arrivalAirportCode, Integer aircraftId, FlightStatus status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.aircraftId = aircraftId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        entityFlight that = (entityFlight) o;
        return Objects.equals(id, that.id) && Objects.equals(flightNo, that.flightNo) && Objects.equals(departureDate, that.departureDate) && Objects.equals(departureAirportCode, that.departureAirportCode) && Objects.equals(arrivalDate, that.arrivalDate) && Objects.equals(arrivalAirportCode, that.arrivalAirportCode) && Objects.equals(aircraftId, that.aircraftId) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNo, departureDate, departureAirportCode, arrivalDate, arrivalAirportCode, aircraftId, status);
    }

    @Override
    public String toString() {
        return "entityFlight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", departureDate=" + departureDate +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", arrivalAirportCode='" + arrivalAirportCode + '\'' +
                ", aircraftId=" + aircraftId +
                ", status=" + status +
                '}';
    }
}
