package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Hobby;

import java.sql.Time;

/**
 * Created by Michael on 05/05/2015.
 */
public class HobbyFactory
{
    public static Hobby createHobby(String personId,String name,int nrDaysOccupied,Time timeSpentPerActivity)
    {
        Hobby hobby = new Hobby.Builder(personId,name,nrDaysOccupied,timeSpentPerActivity).build();
        return hobby;
    }
}
