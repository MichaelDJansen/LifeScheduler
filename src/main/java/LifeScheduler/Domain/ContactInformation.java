package LifeScheduler.Domain;

import javax.persistence.Embeddable;

/**
 * Created by Michael on 17/04/2015.
 */

@Embeddable
public class ContactInformation
{
    private String contactId;
    private String contactNumber;
    private String twitter;
    private String facebook;

    private ContactInformation(){}

    public ContactInformation(Builder builder){
        contactId = builder.contactId;
        contactNumber = builder.contactNumber;
        twitter = builder.twitter;
        facebook = builder.facebook;
    }

    public static class Builder{

        private String contactId;
        private String contactNumber;
        private String twitter;
        private String facebook;

        public Builder(String contactId,String contactNumber){
            this.contactId = contactId;
            this.contactNumber = contactNumber;
        }

        public Builder ContactNumber(String contactNumber){
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder Twitter(String twitter){
            this.twitter = twitter;
            return this;
        }

        public Builder Facebook(String facebook){
            this.facebook = facebook;
            return this;
        }

        public Builder Copy(ContactInformation value){
            this.facebook = value.getFacebook();
            this.contactNumber = value.getContactNumber();
            this.twitter = value.getTwitter();
            this.contactId = value.getContactId();
            return this;
        }

        public ContactInformation build(){
            return new ContactInformation(this);
        }
    }
    public String getContactId() {
        return contactId;
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
