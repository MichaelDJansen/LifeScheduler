package LifeScheduler.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class Friend implements Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String personId;
    private String name;
    private String surname;
    private Address address;
    private ContactInformation contactInformation;
    private Statistics personStats;
    private String levelOfImportance;
    private String meetingPlace;

    private Friend(){}

    Friend(Builder builder){
    }

    public static class Builder{

        private String personId;
        private String name;
        private String surname;
        private Address address;
        private ContactInformation contactInformation;
        private Statistics personStats;
        private String levelOfImportance;
        private String meetingPlace;

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

        public Builder meetingPlace(String meetingPlace){
            this.meetingPlace = meetingPlace;
            return this;
        }

        public Builder copy(Friend value){

            this.personId = value.getPersonId();
            this.name = value.getName();
            this.surname = value.getSurname();
            this.address = value.getAddress();
            this.contactInformation = value.getContactInformation();
            this.personStats = value.getPersonStats();
            this.levelOfImportance = value.getLevelOfImportance();
            this.meetingPlace = value.getMeetingPlace();
            return this;
        }

        public Friend build()
        {
            return new Friend(this);
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

    public String getMeetingPlace() {
        return meetingPlace;
    }
}
