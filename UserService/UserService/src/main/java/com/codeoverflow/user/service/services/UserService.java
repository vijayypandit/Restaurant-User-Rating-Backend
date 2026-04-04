package com.codeoverflow.user.service.services;

import com.codeoverflow.user.service.entities.User;
import java.util.*;
public interface UserService {

    //user all operations

    //create user
    User saveUser(User user);

    //get users
    List<User> getAllUser();

    //getuser by id
    User getUser(String userId)   ;

    //Update and Delete operation method .



}
