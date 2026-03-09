package cz.uhk.spring1.service;

import cz.uhk.spring1.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(long id);
    List<User> getAllUsers();
}
