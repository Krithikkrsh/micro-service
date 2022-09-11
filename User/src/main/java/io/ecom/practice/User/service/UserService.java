package io.ecom.practice.User.service;

import io.ecom.practice.User.dto.UserDto;

import java.util.List;

public interface UserService {

    void addUser(UserDto user);

    List<UserDto> getUsers();
}
