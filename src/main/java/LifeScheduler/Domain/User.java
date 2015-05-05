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
    private String userId;
    private Calendar calendar;
    @OneToMany
    private ArrayList<Hobby> hobbies;
    @OneToMany
    private ArrayList<Person> familyAndFriends;
    @OneToMany
    private ArrayList<Person> favourites;
    private Occupation occupation;

    private User(){}

    public User(Builder builder)
    {
        userId = builder.userId;
        calendar = builder.calendar;
        hobbies = builder.hobbies;
        familyAndFriends = builder.familyAndFriends;
        favourites = builder.favourites;
        occupation = builder.occupation;
    }

    public static class Builder{

        private String userId;
        private Calendar calendar;
        private ArrayList<Hobby> hobbies;
        private ArrayList<Person> familyAndFriends;
        private ArrayList<Person> favourites;
        private Occupation occupation;

        public Builder(String userId,Calendar calendar,ArrayList<Hobby> hobbies,ArrayList<Person> familyAndFriends,ArrayList<Person> favourites,Occupation occupation)
        {
            this.userId = userId;
            this.calendar = calendar;
            this.hobbies = hobbies;
            this.familyAndFriends = familyAndFriends;
            this.favourites = favourites;
            this.occupation = occupation;
        }

        public Builder copy(User user)
        {
            this.userId = user.getUserId();
            this.calendar = user.getCalendar();
            this.hobbies = user.getHobbies();
            this.familyAndFriends = user.getFamilyAndFriends();
            this.favourites = user.getFavourites();
            this.occupation = user.getOccupation();

            return this;
        }

        public User build(){return new User(this);}
    }

    public String getUserId() {
        return userId;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }

    public ArrayList<Person> getFamilyAndFriends() {
        return familyAndFriends;
    }

    public ArrayList<Person> getFavourites() {
        return favourites;
    }

    public Occupation getOccupation() {
        return occupation;
    }
}
