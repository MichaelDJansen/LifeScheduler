package LifeScheduler.conf.factory;

import LifeScheduler.Domain.ContactInformation;

/**
 * Created by Michael on 05/05/2015.
 */
public class ContactInformationFactory
{
    public static ContactInformation createContactInformation(String contactNumber,String facebook,String twitter)
    {
        ContactInformation contactInformation = new ContactInformation
                .Builder(contactNumber)
                .facebook(facebook)
                .twitter(twitter)
                .build();
        return contactInformation;
    }
}
