package LifeScheduler.Domain;

/**
 * Created by Michael on 17/04/2015.
 */
public abstract class Person
{
    private String name;
    private String surname;
    private Address address;
    private ContactInformation contactInformation;
    private Statistics personStats;
    private String levelOfImportance;

    public abstract void contact();
}
