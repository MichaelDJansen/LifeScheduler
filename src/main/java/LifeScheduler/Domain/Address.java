package LifeScheduler.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michael on 17/04/2015.
 */

@Embeddable
public class Address implements Serializable
{
    String streetName;
    String houseNumber;
    String suburb;
    String postalCode;

    public Address(Builder builder)
    {
        streetName = builder.streetName;
        houseNumber = builder.houseNumber;
        suburb = builder.suburb;
        postalCode = builder.postalCode;
    }

    private Address(){}

    public static class Builder{
        String streetName;
        String houseNumber;
        String suburb;
        String postalCode;

        public Builder (String streetName,String houseNumber,String suburb,String postalCode){
            this.streetName = streetName;
            this.houseNumber = houseNumber;
            this.suburb = suburb;
            this.postalCode = postalCode;
        }

        public Builder copy(Address value){
            this.streetName = value.getStreetName();
            this.houseNumber = value.getHouseNumber();
            this.suburb = value.getSuburb();
            this.postalCode = value.getPostalCode();
            return this;
        }

        public Builder streetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        public Builder houseNumber(String houseNumber){
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder suburb(String suburb){
            this.suburb = suburb;
            return this;
        }

        public Builder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
