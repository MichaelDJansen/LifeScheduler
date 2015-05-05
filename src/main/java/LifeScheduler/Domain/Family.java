package LifeScheduler.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class Family implements Person
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
    private String relation;

    private Family(){}

    Family(Builder builder){
    }

    public static class Builder{

        private String personId;
        private String name;
        private String surname;
        private Address address;
        private ContactInformation contactInformation;
        private Statistics personStats;
        private String levelOfImportance;
        private String relation;

        public Builder(String personId,String name,String surname){
            this.personId = personId;
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

        public Builder relation(String relation){
            this.relation = relation;
            return this;
        }

        public Builder copy(Family value){

            this.personId = value.getPersonId();
            this.name = value.getName();
            this.surname = value.getSurname();
            this.address = value.getAddress();
            this.contactInformation = value.getContactInformation();
            this.personStats = value.getPersonStats();
            this.levelOfImportance = value.getLevelOfImportance();
            this.relation = value.getRelation();
            return this;
        }

        public Family build()
        {
            return new Family(this);
        }
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

    public String getRelation() { return relation; }
}
