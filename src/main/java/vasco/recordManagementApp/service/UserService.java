package vasco.recordManagementApp.service;

import vasco.recordManagementApp.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}
