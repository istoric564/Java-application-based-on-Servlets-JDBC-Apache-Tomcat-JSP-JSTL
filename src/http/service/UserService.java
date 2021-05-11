package http.service;

import http.dao.UserDao;
import http.dto.CreateUserDto;
import http.entity.UserEntity;
import http.exception.ValidationException;
import http.mapper.CreateUserMapper;
import http.validator.CreateUserValidator;
import http.validator.ValidationResult;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getINSTANCE();

    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
//        validation
//        преобразовать в map
//        userDao.save
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
