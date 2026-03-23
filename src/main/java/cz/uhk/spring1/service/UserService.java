package cz.uhk.spring1.service;

import cz.uhk.spring1.model.User;
import cz.uhk.spring1.model.dto.UserBasicsDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(long id);
    List<User> getAllUsers();

    UserBasicsDTO getUserDTO(String mail);
}
