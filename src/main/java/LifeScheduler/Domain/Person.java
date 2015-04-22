package LifeScheduler.Domain;

/**
 * Created by Michael on 17/04/2015.
 */
public abstract class Person
{
    //@Entity
    //@Id
    private String personId;
    private String name;
    private String surname;
    //@Embeddable
    private Address address;
    //@Embeddable
    private ContactInformation contactInformation;
    //@Embeddable
    private Statistics personStats;
    private String levelOfImportance;

    public abstract void contact();
}
