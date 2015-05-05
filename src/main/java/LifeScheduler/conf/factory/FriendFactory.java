package LifeScheduler.conf.factory;

import LifeScheduler.Domain.*;

/**
 * Created by Michael on 05/05/2015.
 */
public class FriendFactory
{
    public static Friend createFamily(String personId,String name,String surname,Address address
            ,ContactInformation contactInformation,Statistics statistics,String levelOfImportance,String meetingPlace)
    {
        Friend friend = new Friend.Builder(personId,name,surname).address(address).contactInformation(contactInformation)
                .statistics(statistics).levelOfImportance(levelOfImportance).meetingPlace(meetingPlace).build();

        return friend;
    }
}
