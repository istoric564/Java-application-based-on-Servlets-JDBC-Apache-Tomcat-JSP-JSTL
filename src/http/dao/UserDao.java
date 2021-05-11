package http.dao;

import http.entity.UserEntity;
import http.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Long, UserEntity> {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, password, role, gender)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public Optional<UserEntity> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    @SneakyThrows
    public UserEntity save(UserEntity entity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            preparedStatement.executeUpdate();

            var resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            entity.setId(resultSet.getObject("id", Integer.class));

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

}
