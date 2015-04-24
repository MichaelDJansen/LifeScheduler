package LifeScheduler.Domain;

import com.sun.org.apache.bcel.internal.generic.FADD;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class User implements Serializable{

    @Id
    private String userID;
    private Calendar calendar;
    @OneToMany
    private ArrayList<Hobby> hobbies;
    @OneToMany
    private ArrayList<Person> familyAndFriends;
    @OneToMany
    private ArrayList<Person> favourites;
    private Occupation occupation;
}
