package LifeScheduler.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 24/04/2015.
 */
public class StatisticsTest extends TestCase 
{
    Statistics statistics1;
    String statId;
    Time timeSpentTogether;
    int nrInteractions;

    @Before
    public void setUp() throws Exception {
        statId = "1";
        timeSpentTogether = new Time(5,10,00);
        nrInteractions = 4;

        statistics1 = new Statistics.Builder(statId,timeSpentTogether,nrInteractions).build();
    }

    @Test
    public void testStatisticsCreation() throws Exception {
        assertEquals(4,statistics1.getNrInteractions());
        assertEquals(new Time(5,10,00),statistics1.getTimeSpentTogether());
        assertEquals("1",statistics1.getStatId());
    }

    public void testStatisticsUpdate() throws Exception {
        assertEquals(4,statistics1.getNrInteractions());

        statistics1 = new Statistics.Builder(statId,timeSpentTogether,nrInteractions).nrInteractions(5).build();

        assertEquals(5,statistics1.getNrInteractions());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
