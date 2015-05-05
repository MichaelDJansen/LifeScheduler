package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Address;
import LifeScheduler.Domain.ContactInformation;
import LifeScheduler.Domain.Family;
import LifeScheduler.Domain.Statistics;

/**
 * Created by Michael on 05/05/2015.
 */
public class FamilyFactory
{
    public static Family createFamily(String personId,String name,String surname,Address address
                        ,ContactInformation contactInformation,Statistics statistics,String levelOfImportance,String relation)
    {
        Family family = new Family.Builder(personId,name,surname).address(address).contactInformation(contactInformation)
                        .statistics(statistics).levelOfImportance(levelOfImportance).relation(relation).build();

        return family;
    }
}
