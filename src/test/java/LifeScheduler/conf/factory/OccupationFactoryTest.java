package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Occupation;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 06/05/2015.
 */
public class OccupationFactoryTest extends TestCase
{
    String name;
    Time start;
    Time finish;
    int nrDaysOccupied;

    Occupation occupation1;

    @Before
    public void setUp() throws Exception
    {
        name = "Software Developer";
        start = new Time(8,30,00);
        finish = new Time(16,30,00);
        nrDaysOccupied = 5;

        occupation1 = OccupationFactory.createOccupation(name,start,finish,nrDaysOccupied);
    }

    @Test
    public void testOccupationCreation() throws Exception
    {
        assertEquals("Software Developer",occupation1.getName());
        assertEquals(new Time(8,30,00),occupation1.getStart());
        assertEquals(new Time(16,30,00),occupation1.getFinish());
        assertEquals(5,occupation1.getNrDaysOccupied());
    }

    public void testOccupationUpdate() throws Exception
    {
        assertEquals("Software Developer",occupation1.getName());

        occupation1 = new Occupation.Builder(name,start,finish,nrDaysOccupied).copy(occupation1).name("Senior Software Developer").build();

        assertEquals("Senior Software Developer",occupation1.getName());
    }

    @After
    public void tearDown() throws Exception
    {

    }
}
