package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Hobby;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 06/05/2015.
 */
public class HobbyFactoryTest extends TestCase
{
    Hobby hobby1;
    String personId;
    String name;
    int nrDaysOccupied;
    Time timeSpentPerActivity;

    @Before
    public void setUp() throws Exception {

        personId = "155";
        name = "Dragonboating";
        nrDaysOccupied = 3;
        timeSpentPerActivity = new Time(01,30,00);

        hobby1 = HobbyFactory.createHobby(personId,name,nrDaysOccupied,timeSpentPerActivity);
    }

    @Test
    public void testHobbyCreation() throws Exception {
        assertEquals("155", hobby1.getPersonId());
        assertEquals("Dragonboating", hobby1.getName());
        assertEquals(3, hobby1.getNrDaysOccupied());
        assertEquals(new Time(1,30,00), hobby1.getTimeSpentPerActivity());
    }

    @After
    public void tearDown() throws Exception {
    }

}
