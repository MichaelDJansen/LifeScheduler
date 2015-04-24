package LifeScheduler.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 24/04/2015.
 */
public class HobbyTest extends TestCase
{
    Hobby hobby1;
    String hobbyId;
    String name;
    int nrDaysOccupied;
    Time timeSpentPerActivity;

    @Before
    public void setUp() throws Exception {

        hobbyId = "155";
        name = "Dragonboating";
        nrDaysOccupied = 3;
        timeSpentPerActivity = new Time(01,30,00);

        hobby1 = new Hobby.Builder(hobbyId,name,nrDaysOccupied,timeSpentPerActivity).build();
    }

    @Test
    public void testHobbyCreation() throws Exception {
        assertEquals("155", hobby1.getHobbyId());
        assertEquals("Dragonboating", hobby1.getName());
        assertEquals(3, hobby1.getNrDaysOccupied());
        assertEquals(new Time(1,30,00), hobby1.getTimeSpentPerActivity());
    }

    @After
    public void tearDown() throws Exception {


    }
}
