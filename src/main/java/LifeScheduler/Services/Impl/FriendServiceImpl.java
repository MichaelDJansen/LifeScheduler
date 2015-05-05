package LifeScheduler.Services.Impl;

import LifeScheduler.Domain.Friend;
import LifeScheduler.Domain.Person;
import LifeScheduler.Repository.FriendRepository;
import LifeScheduler.Services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */

@Service
public class FriendServiceImpl implements FriendService
{
    @Autowired
    FriendRepository repository;

    public ArrayList<Friend> getFriends()
    {
        ArrayList<Friend> allFriends = new ArrayList<Friend>();

        Iterable<Friend> friends = repository.findAll();
        for (Friend friend : friends) {
            allFriends.add(friend);
        }

        return allFriends;
    }
}
