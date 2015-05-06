package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Statistics;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by Michael on 06/05/2015.
 */
public class StatisticsFactoryTest extends TestCase
{
    Statistics statistics1;
    String personId;
    Time timeSpentTogether;
    int nrInteractions;

    @Before
    public void setUp() throws Exception {
        personId = "1";
        timeSpentTogether = new Time(5,10,00);
        nrInteractions = 4;

        statistics1 = StatisticsFactory.createStatistics(personId,timeSpentTogether,nrInteractions);
    }

    @Test
    public void testStatisticsCreation() throws Exception {
        assertEquals(4,statistics1.getNrInteractions());
        assertEquals(new Time(5,10,00),statistics1.getTimeSpentTogether());
        assertEquals("1",statistics1.getPersonId());
    }

    public void testStatisticsUpdate() throws Exception {
        assertEquals(4,statistics1.getNrInteractions());

        statistics1 = new Statistics.Builder(personId,timeSpentTogether,nrInteractions).copy(statistics1).nrInteractions(5).build();

        assertEquals(5,statistics1.getNrInteractions());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
