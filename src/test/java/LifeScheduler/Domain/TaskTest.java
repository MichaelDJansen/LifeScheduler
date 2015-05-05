package LifeScheduler.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Michael on 24/04/2015.
 */
public class TaskTest extends TestCase
{

    Task task1;
    String taskId,taskName,description;
    Time startTime,finishTime;
    Date date;

    @Before
    public void setUp() throws Exception {
        taskId = "1";
        taskName = "Take out trash";
        description = "Take out the trash once you get home";
        startTime = new Time(15,30,00);
        finishTime = new Time(15,32,00);
        date = new Date(2015,10,11);

        task1 = new Task.Builder(taskId,taskName,startTime,finishTime,date).description(description).build();
    }

    @Test
    public void testTaskCreation() throws Exception
    {
        assertEquals("1", task1.getPersonId());
        assertEquals("Take out trash",task1.getTaskName());
        assertEquals("Take out the trash once you get home",task1.getDescription());
        assertEquals(new Time(15,30,00),task1.getStartTime());
        assertEquals(new Time(15,32,00),task1.getFinishTime());
        assertEquals(new Date(2015,10,11),task1.getDate());
    }

    public void testTaskUpdate() throws Exception
    {
        assertEquals("Take out the trash once you get home",task1.getDescription());
        task1 = new Task.Builder(taskId,taskName,startTime,finishTime,date).copy(task1).description("Take out the trash in the kitchen").build();
        assertEquals("Take out the trash in the kitchen",task1.getDescription());
    }
    @After
    public void tearDown() throws Exception {

    }
}
