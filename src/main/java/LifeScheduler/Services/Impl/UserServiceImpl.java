package LifeScheduler.Services.Impl;

import LifeScheduler.Domain.User;
import LifeScheduler.Repository.UserRepository;
import LifeScheduler.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository repository;

    public ArrayList<User> getUsers() {
        ArrayList<User> allUsers = new ArrayList<User>();

        Iterable<User> users = repository.findAll();

        for(User user:users)
        {
            allUsers.add(user);
        }

        return allUsers;
    }
}
