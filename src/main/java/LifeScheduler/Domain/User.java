package LifeScheduler.Domain;

import com.sun.org.apache.bcel.internal.generic.FADD;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 17/04/2015.
 */
public class User implements Serializable{
    //@Id
    //@Auto
    private String userID;
    //@Embeddable
    private Calendar calendar;
    //@Embeddable
    //@OneToMany
    private ArrayList<Hobby> hobbies;
    //@Embeddable
    //@OneToMany
    private ArrayList<Person> familyAndFriends;
    //@Embeddable
    //@OneToMany
    private ArrayList<Person> favourites;
    //@Embeddable
    private Occupation occupation;
}
