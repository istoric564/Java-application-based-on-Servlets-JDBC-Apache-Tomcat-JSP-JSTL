package http.dao;

import http.entity.FlightStatus;
import http.entity.entityFlight;
import http.util.ConnectionManager;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.naming.Context;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FlightDao implements Dao<Long, entityFlight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL = """
            SELECT *
            FROM flight
            """;

    public FlightDao() {
    }

    @Override
    public List<entityFlight> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<entityFlight> flights = new ArrayList<>();

            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }
            return flights;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Optional<entityFlight> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(entityFlight entity) {
    }

    @Override
    public entityFlight save(entityFlight entity) {
        return null;
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }


    public entityFlight buildFlight(ResultSet resultSet) throws SQLException {
        return new entityFlight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class)));
    }
}
