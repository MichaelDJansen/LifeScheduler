package LifeScheduler.Domain;

import javax.persistence.Entity;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class Friend extends Person {


    private String meetingPlace;

    private Friend(){
        super();
    }

    public Friend(Address.Builder builder){

    }

    public static class Builder{

        private String meetingPlace;


    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    @Override
    public void contact(){}
}
