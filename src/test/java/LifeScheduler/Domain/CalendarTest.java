package LifeScheduler.Domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Michael on 24/04/2015.
 */
public class CalendarTest extends TestCase
{
    Calendar calendar1;
    Task task1,task2;
    String taskId1,taskName1,description1;
    Time startTime1,finishTime1;
    Date date1;
    String taskId2,taskName2,description2;
    Time startTime2,finishTime2;
    Date date2;
    ArrayList<Task> events;
    String calendarId;

    @Before
    public void setUp() throws Exception {
        calendarId = "331";

        taskId1 = "1";
        taskName1 = "Take out trash";
        description1 = "Take out the trash once you get home";
        startTime1 = new Time(15,30,00);
        finishTime1 = new Time(15,32,00);
        date1 = new Date(2015,10,11);

        task1 = new Task.Builder(taskId1,taskName1,startTime1,finishTime1,date1).description(description1).build();

        taskId2 = "2";
        taskName2 = "Clean room";
        description2 = "Clean your room thoroughly which includes vacuuming under the bed";
        startTime2 = new Time(16,00,00);
        finishTime2 = new Time(16,20,00);
        date2 = new Date(2015,10,11);

        task2 = new Task.Builder(taskId2,taskName2,startTime2,finishTime2,date2).description(description2).build();



        events = new ArrayList<Task>();
        events.add(task1);
        events.add(task2);

        calendar1 = new Calendar.Builder(calendarId,events).build();
    }

    @Test
    public void testCalendarCreation() throws Exception {
        assertEquals("331",calendar1.getPersonId());

        assertEquals("1",calendar1.getEvents().get(0).getPersonId());
        assertEquals("Take out trash",calendar1.getEvents().get(0).getTaskName());
        assertEquals("Take out the trash once you get home",calendar1.getEvents().get(0).getDescription());
        assertEquals(new Time(15,30,00),calendar1.getEvents().get(0).getStartTime());
        assertEquals(new Time(15,32,00),calendar1.getEvents().get(0).getFinishTime());
        assertEquals(new Date(2015,10,11),calendar1.getEvents().get(0).getDate());

        assertEquals("2",calendar1.getEvents().get(1).getPersonId());
        assertEquals("Clean room",calendar1.getEvents().get(1).getTaskName());
        assertEquals("Clean your room thoroughly which includes vacuuming under the bed",calendar1.getEvents().get(1).getDescription());
        assertEquals(new Time(16,00,00),calendar1.getEvents().get(1).getStartTime());
        assertEquals(new Time(16,20,00),calendar1.getEvents().get(1).getFinishTime());
        assertEquals(new Date(2015,10,11),calendar1.getEvents().get(1).getDate());
    }

    public void testCalendarUpdate() throws Exception {
        assertEquals("331",calendar1.getPersonId());

        assertEquals("1",calendar1.getEvents().get(0).getPersonId());
        assertEquals("Take out trash",calendar1.getEvents().get(0).getTaskName());
        assertEquals("Take out the trash once you get home",calendar1.getEvents().get(0).getDescription());
        assertEquals(new Time(15,30,00),calendar1.getEvents().get(0).getStartTime());
        assertEquals(new Time(15,32,00),calendar1.getEvents().get(0).getFinishTime());
        assertEquals(new Date(2015,10,11),calendar1.getEvents().get(0).getDate());


        taskId1 = "1";
        taskName1 = "Take out the trash";
        description1 = "Take out the trash once you get home";
        startTime1 = new Time(15,30,00);
        finishTime1 = new Time(15,35,00);
        date1 = new Date(2015,10,11);

        task1 = new Task.Builder(taskId1,taskName1,startTime1,finishTime1,date1).description(description1).build();

        ArrayList<Task> events1 = new ArrayList<Task>();
        events1.add(task1);
        events1.add(task2);

        calendar1 = new Calendar.Builder(calendarId,events1).copy(calendar1).events(events1).build();

        assertEquals("331",calendar1.getPersonId());

        assertEquals("1",calendar1.getEvents().get(0).getPersonId());
        assertEquals("Take out the trash",calendar1.getEvents().get(0).getTaskName());
        assertEquals("Take out the trash once you get home",calendar1.getEvents().get(0).getDescription());
        assertEquals(new Time(15,30,00),calendar1.getEvents().get(0).getStartTime());
        assertEquals(new Time(15,35,00),calendar1.getEvents().get(0).getFinishTime());
        assertEquals(new Date(2015,10,11),calendar1.getEvents().get(0).getDate());

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
