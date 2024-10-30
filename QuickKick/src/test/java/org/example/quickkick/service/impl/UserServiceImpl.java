package org.example.quickkick.service.impl;

import org.example.quickkick.model.User;
import org.example.quickkick.model.exceptions.InvalidUserCredentialsEception;
import org.example.quickkick.model.exceptions.PasswordsDoNotMatchException;
import org.example.quickkick.model.exceptions.UserNameAlreadyExistsException;
import org.example.quickkick.repository.UserRepository;
import org.example.quickkick.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || password == null) {
            throw new InvalidUserCredentialsEception();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsEception::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty())
        {
            throw new InvalidUserCredentialsEception();
        }
        if(!password.equals(repeatPassword))
        {
            throw new PasswordsDoNotMatchException();
        }
        if(this.userRepository.findByUsername(username).isPresent() || !this.userRepository.findByUsername(username).isEmpty())
        {
            throw new UserNameAlreadyExistsException(username);
        }
        User user=new User(username,password);
        return this.userRepository.save(user);
    }
}
