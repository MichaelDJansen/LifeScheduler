package LifeScheduler.Domain;

import LifeScheduler.conf.factory.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 06/05/2015.
 */
public class FriendTest extends TestCase
{
    Friend friend;
    String name,surname,levelOfImportance,meetingPlace;
    Address address;
    ContactInformation contactInformation;
    Statistics personStats;

    @Before
    public void setUp() throws Exception
    {
        name = "Peter";
        surname = "Johnson";
        levelOfImportance = "Medium";
        address =  AddressFactory.createAddress("Hammond Street", "55", "Hadefield", "7500");
        contactInformation = ContactInformationFactory.createContactInformation("0756685697","Peter Johnson","@PeterJ");
        personStats = StatisticsFactory.createStatistics("1",new Time(00,50,90),5);
        meetingPlace = "School";

        friend = FriendFactory.createFamily("1", name, surname, address, contactInformation, personStats, levelOfImportance, meetingPlace);
    }

    @Test
    public void testFamilyCreation() throws Exception
    {
        assertNotNull(friend);

        assertEquals("Peter", friend.getName());
        assertEquals("Johnson",friend.getSurname());
        assertEquals("Medium",friend.getLevelOfImportance());
        assertEquals("Hammond Street",friend.getAddress().getStreetName());
        assertEquals("@PeterJ",friend.getContactInformation().getTwitter());
        assertEquals("1",friend.getPersonStats().getPersonId());
        assertEquals("School",friend.getMeetingPlace());
    }

    @Test
    public void testFamilyUpdate() throws Exception
    {
        assertNotNull(friend);

        assertEquals("Peter",friend.getName());
        assertEquals("Johnson",friend.getSurname());
        assertEquals("Medium",friend.getLevelOfImportance());
        assertEquals("Hammond Street",friend.getAddress().getStreetName());
        assertEquals("@PeterJ",friend.getContactInformation().getTwitter());
        assertEquals("1",friend.getPersonStats().getPersonId());

        friend = new Friend.Builder("1","Peter","Johnson").copy(friend).meetingPlace("College").build();

        assertEquals("C",friend.getMeetingPlace());
    }

    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }
}