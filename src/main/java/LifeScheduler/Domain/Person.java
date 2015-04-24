package LifeScheduler.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public abstract class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String personId;
    private String name;
    private String surname;
    private Address address;
    private ContactInformation contactInformation;
    private Statistics personStats;
    private String levelOfImportance;

    protected Person(){}

    protected Person(String personId,String name,String surname,Address address,ContactInformation contactInformation,Statistics personStats,String levelOfImportance){
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.contactInformation = contactInformation;
        this.personStats = personStats;
        this.levelOfImportance = levelOfImportance;
    }
    Person(Builder builder){
    }

    public static class Builder{

        private String personId;
        private String name;
        private String surname;
        private Address address;
        private ContactInformation contactInformation;
        private Statistics personStats;
        private String levelOfImportance;

        Builder(String name,String surname){
            this.name = name;
            this.surname = surname;
        }

        public Builder address(Address address)
        {
            this.address = address;
            return this;
        }

        public Builder contactInformation(ContactInformation contactInformation)
        {
            this.contactInformation = contactInformation;
            return this;
        }

        public Builder statistics(Statistics statistics){
            this.personStats = statistics;
            return this;
        }

        public Builder levelOfImportance(String levelOfImportance){
            this.levelOfImportance = levelOfImportance;
            return this;
        }

        /*public Person build()
        {
            return new Person(this);
        }*/
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public Statistics getPersonStats() {
        return personStats;
    }

    public String getLevelOfImportance() {
        return levelOfImportance;
    }

    public abstract void contact();
}
