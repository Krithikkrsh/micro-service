package io.ecom.practice.User.service.Imp;

import io.ecom.practice.User.dao.UserMapper;
import io.ecom.practice.User.dto.UserDto;
import io.ecom.practice.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public void addUser(UserDto user) {
        OffsetDateTime dateTime = OffsetDateTime.now();
        Timestamp t = Timestamp.valueOf(LocalDateTime.ofInstant(dateTime.toInstant(), ZoneOffset.UTC));
        user.setUserPassword(BCrypt.hashpw(user.getUserPassword(),BCrypt.gensalt()));
        user.setCreatedAt(Timestamp.from(Instant.now()));
        user.setUpdatedAt(Timestamp.from(Instant.now()));
        mapper.addUser(user);
        mapper.addAddress(user.getUserAddress(), user.getUserPhoneNumber());

    }

    @Override
    public List<UserDto> getUsers() {
        return mapper.getUsers();
    }
}
