package cz.uhk.spring1.service;

import cz.uhk.spring1.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void saveUser(User user) {
        if(user != null){
            if(user.getId() == 0){
                int id = 1;
                if(!users.isEmpty()){
                    id = users.get(users.size()-1).getId()+1;
                }
                user.setId(id);
                users.add(user);
            }else{
                User u = getUser(user.getId());
                if(u != null){
                    u.setName(user.getName());
                    u.setPassword(user.getPassword());
                }
            }
        }
    }

    @Override
    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if(user != null){
            users.remove(user);
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return users;
    }

}
