package org.example.quickkick.service;

import org.example.quickkick.model.User;

public interface UserService {

    User login(String username, String password);
    User register(String username, String password,String repeatPassword);

}
