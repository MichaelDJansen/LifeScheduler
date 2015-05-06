package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Address;
import LifeScheduler.Domain.ContactInformation;
import LifeScheduler.Domain.Family;
import LifeScheduler.Domain.Statistics;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 06/05/2015.
 */
public class FamilyFactoryTest extends TestCase
{
    Family family;
    String name,surname,levelOfImportance,relation;
    Address address;
    ContactInformation contactInformation;
    Statistics personStats;

    @Before
    public void setUp() throws Exception
    {
        name = "Peter";
        surname = "Johnson";
        levelOfImportance = "High";
        address =  AddressFactory.createAddress("Hammond Street", "55", "Hadefield", "7500");
        contactInformation = ContactInformationFactory.createContactInformation("0756685697","Peter Johnson","@PeterJ");
        personStats = StatisticsFactory.createStatistics("1",new Time(00,50,90),5);
        relation = "Second Cousin";

        family = FamilyFactory.createFamily("1",name,surname,address,contactInformation,personStats,levelOfImportance,relation);
    }

    @Test
    public void testFamilyCreation() throws Exception
    {
        assertNotNull(family);

        assertEquals("Peter",family.getName());
        assertEquals("Johnson",family.getSurname());
        assertEquals("High",family.getLevelOfImportance());
        assertEquals("Hammond Street",family.getAddress().getStreetName());
        assertEquals("@PeterJ",family.getContactInformation().getTwitter());
        assertEquals("1",family.getPersonStats().getPersonId());
        assertEquals("Second Cousin",family.getRelation());
    }

    @Test
    public void testFamilyUpdate() throws Exception
    {
        assertNotNull(family);

        assertEquals("Peter",family.getName());
        assertEquals("Johnson",family.getSurname());
        assertEquals("High",family.getLevelOfImportance());
        assertEquals("Hammond Street",family.getAddress().getStreetName());
        assertEquals("@PeterJ",family.getContactInformation().getTwitter());
        assertEquals("1",family.getPersonStats().getPersonId());

        family = new Family.Builder("1","Peter","Johnson").copy(family).relation("Cousin").build();

        assertEquals("Cousin",family.getRelation());
    }

    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }
}
