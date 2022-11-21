package by.creatorlab.services;

import by.creatorlab.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1L,"user1","user1","user1@gmail.com","+111 11 111 11 11"));
        userList.add(new User(2L,"user2","user2","user2@gmail.com","+222 22 222 22 22"));
        userList.add(new User(3L,"user3","user3","user3@gmail.com","+333 33 333 33 33"));
        userList.add(new User(4L,"user4","user4","user4@gmail.com","+444 44 444 44 44"));
        userList.add(new User(5L,"user5","user5","user5@gmail.com","+555 55 555 55 55"));
        userList.add(new User(6L,"user6","user6","user6@gmail.com","+666 66 666 66 66"));
    }

    public List<User> getUserList() {
        return userList;
    }
}
