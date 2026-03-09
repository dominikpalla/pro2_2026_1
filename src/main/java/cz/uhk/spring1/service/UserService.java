package cz.uhk.spring1.service;

import cz.uhk.spring1.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
    ArrayList<User> getAllUsers();
}
