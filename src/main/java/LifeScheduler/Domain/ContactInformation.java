package LifeScheduler.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Michael on 17/04/2015.
 */

@Embeddable
public class ContactInformation implements Serializable
{
    private String contactNumber;
    private String twitter;
    private String facebook;

    private ContactInformation(){}

    public ContactInformation(Builder builder){
        contactNumber = builder.contactNumber;
        twitter = builder.twitter;
        facebook = builder.facebook;
    }

    public static class Builder{


        private String contactNumber;
        private String twitter;
        private String facebook;

        public Builder(String contactNumber){
            this.contactNumber = contactNumber;
        }

        public Builder ContactNumber(String contactNumber){
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder twitter(String twitter){
            this.twitter = twitter;
            return this;
        }

        public Builder facebook(String facebook){
            this.facebook = facebook;
            return this;
        }

        public Builder Copy(ContactInformation value){
            this.facebook = value.getFacebook();
            this.contactNumber = value.getContactNumber();
            this.twitter = value.getTwitter();

            return this;
        }

        public ContactInformation build(){
            return new ContactInformation(this);
        }
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getFacebook() {
        return facebook;
    }
}
