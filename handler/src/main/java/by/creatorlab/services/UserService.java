package by.creatorlab.services;

import by.creatorlab.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1,"user1","user1","user1@gmail.com","+111 11 111 11 11","role"));
        userList.add(new User(2,"user2","user2","user2@gmail.com","+222 22 222 22 22","role"));
        userList.add(new User(3,"user3","user3","user3@gmail.com","+333 33 333 33 33","role"));
        userList.add(new User(4,"user4","user4","user4@gmail.com","+444 44 444 44 44","role"));
        userList.add(new User(5,"user5","user5","user5@gmail.com","+555 55 555 55 55","role"));
        userList.add(new User(6,"user6","user6","user6@gmail.com","+666 66 666 66 66","role"));
    }

    public List<User> getUserList() {
        return userList;
    }
}
