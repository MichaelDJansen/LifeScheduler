package LifeScheduler.conf.factory;

import LifeScheduler.Domain.*;

import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */
public class UserFactory
{
    public static User createUser(String userId,Calendar calendar,ArrayList<Hobby> hobbies,ArrayList<Person> familyAndFriends,ArrayList<Person> favourites,Occupation occupation)
    {
        User user = new User.Builder(userId, calendar, hobbies, familyAndFriends, favourites, occupation).build();

        return user;
    }
}