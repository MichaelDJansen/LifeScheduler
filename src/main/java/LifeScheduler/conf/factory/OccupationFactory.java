package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Occupation;

import java.sql.Time;

/**
 * Created by Michael on 05/05/2015.
 */
public class OccupationFactory
{
    public static Occupation createOccupation(String name,Time start,Time finish,int nrDaysOccupied)
    {
        Occupation occupation = new Occupation.Builder(name,start,finish,nrDaysOccupied).build();
        return occupation;
    }
}
