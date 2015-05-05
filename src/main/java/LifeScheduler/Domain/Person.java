package LifeScheduler.Domain;

/**
 * Created by Michael on 17/04/2015.
 */

public interface Person
{
    String getPersonId();
    String getName();
    String getSurname();
    Address getAddress();
    ContactInformation getContactInformation();
    Statistics getPersonStats();
    String getLevelOfImportance();
}
