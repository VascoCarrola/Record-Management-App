package vasco.recordManagementApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasco.recordManagementApp.Repository.UserRepository;
import vasco.recordManagementApp.model.User;
import vasco.recordManagementApp.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
