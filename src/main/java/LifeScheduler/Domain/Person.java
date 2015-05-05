package LifeScheduler.Domain;

import java.io.Serializable;

/**
 * Created by Michael on 17/04/2015.
 */

public interface Person extends Serializable
{
    String getPersonId();
    String getName();
    String getSurname();
    Address getAddress();
    ContactInformation getContactInformation();
    Statistics getPersonStats();
    String getLevelOfImportance();
}
