package cz.uhk.spring1.service;

import cz.uhk.spring1.model.User;
import cz.uhk.spring1.model.dto.UserBasicsDTO;
import cz.uhk.spring1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        User user = getUser(id);
        if(user != null){
            userRepository.delete(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserBasicsDTO getUserDTO(String mail) {
        return userRepository.findByEmail(mail);
    }

}
