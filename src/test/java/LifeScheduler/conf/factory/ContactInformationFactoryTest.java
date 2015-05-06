package LifeScheduler.conf.factory;

import LifeScheduler.Domain.ContactInformation;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

/**
 * Created by Michael on 06/05/2015.
 */
public class ContactInformationFactoryTest extends TestCase
{
    ContactInformation contactInformation1;


    String contactNumber;
    String twitter;
    String facebook;

    @Before
    public void setUp() throws Exception {
        contactNumber = "0735586997";
        twitter = "@RoboTechnique";
        facebook = "Robert Technicue";

        contactInformation1 = ContactInformationFactory.createContactInformation(contactNumber,facebook,twitter);
    }

    public void testContactinformationCreation() throws Exception {

        assertEquals("0735586997",contactInformation1.getContactNumber());
        assertEquals("@RoboTechnique",contactInformation1.getTwitter());
        assertEquals("Robert Technicue",contactInformation1.getFacebook());

    }

    public void testContactinformationUpdate() throws Exception {

        assertEquals("0735586997",contactInformation1.getContactNumber());

        contactInformation1 = new ContactInformation.Builder(contactNumber).Copy(contactInformation1).ContactNumber("0735588667").build();

        assertEquals("0735588667",contactInformation1.getContactNumber());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
