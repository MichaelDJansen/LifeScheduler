package LifeScheduler.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

/**
 * Created by Michael on 24/04/2015.
 */
public class ContactInformationTest extends TestCase
{
    ContactInformation contactInformation1;

    String contactId;
    String contactNumber;
    String twitter;
    String facebook;

    @Before
    public void setUp() throws Exception {
        contactId = "1";
        contactNumber = "0735586997";
        twitter = "@RoboTechnique";
        facebook = "Robert Technicue";

        contactInformation1 = new ContactInformation.Builder(contactId,contactNumber).twitter(twitter).facebook(facebook).build();
    }

    public void testContactinformationCreation() throws Exception {

        assertEquals("1",contactInformation1.getPersonId());
        assertEquals("0735586997",contactInformation1.getContactNumber());
        assertEquals("@RoboTechnique",contactInformation1.getTwitter());
        assertEquals("Robert Technicue",contactInformation1.getFacebook());

    }

    public void testContactinformationUpdate() throws Exception {

        assertEquals("0735586997",contactInformation1.getContactNumber());

        contactInformation1 = new ContactInformation.Builder(contactId,contactNumber).Copy(contactInformation1).ContactNumber("0735588667").build();

        assertEquals("0735588667",contactInformation1.getContactNumber());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
