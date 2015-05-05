package LifeScheduler.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 25/04/2015.
 */
public class AddressTest extends TestCase
{
    Address address1;

    String streetName;
    String houseNumber;
    String suburb;
    String postalCode;

    @Before
    public void setUp() throws Exception
    {
        streetName = "Jakobo Street";
        houseNumber = "25";
        suburb = "Purdale";
        postalCode = "7400";

        address1 = new Address.Builder(streetName,houseNumber,suburb,postalCode).build();
    }

    @Test
    public void testAddressCreation() throws Exception
    {
        assertEquals("Jakobo Street",address1.getStreetName());
        assertEquals("25",address1.getHouseNumber());
        assertEquals("Purdale",address1.getSuburb());
        assertEquals("7400",address1.getPostalCode());
    }

    public void testAddressUpdate() throws Exception
    {
        assertEquals("Jakobo Street",address1.getStreetName());

        address1 = new Address.Builder(streetName,houseNumber,suburb,postalCode).copy(address1).streetName("Jakob Street").build();

        assertEquals("Jakob Street",address1.getStreetName());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
