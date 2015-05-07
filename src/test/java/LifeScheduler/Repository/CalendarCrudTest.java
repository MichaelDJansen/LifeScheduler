package LifeScheduler.Repository;

import LifeScheduler.App;
import LifeScheduler.Domain.Calendar;
import LifeScheduler.Domain.Task;
import LifeScheduler.Services.CalendarService;
import LifeScheduler.Services.Impl.CalendarServiceImpl;
import LifeScheduler.conf.factory.CalendarFactory;
import LifeScheduler.conf.factory.TaskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 06/05/2015.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CalendarCrudTest extends AbstractTestNGSpringContextTests {

    private String id;

    @Autowired
    private CalendarRepository repository;

    @Test
    public void create() throws Exception {

        ArrayList<Task> events = new ArrayList<Task>();

        Time start = new Time(13,50,00);
        Time finish = new Time(15,00,00);
        Date date = new Date(2015,10,12);
        Task task1 = TaskFactory.createTask("1","Test",start,finish,date);
        Task task2 = TaskFactory.createTask("5","Test 213",start,finish,date);

        events.add(task1);
        events.add(task2);

        Calendar Michael = CalendarFactory.createCalendar("1",events);
        Calendar Trevor = CalendarFactory.createCalendar("1",events);

        List<Calendar> calendars = new ArrayList<Calendar>();
        calendars.add(Michael);
        calendars.add(Trevor);

        repository.save(Michael);
        id=Michael.getCalendarId();
        Assert.assertNotNull(Michael.getCalendarId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Calendar test = repository.findOne(id);
        Assert.assertNotNull(test.getCalendarId());
        Assert.assertEquals("Test 213", test.getEvents().get(1).getTaskName());
        Assert.assertTrue(test.getEvents().size() == 2);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Calendar test = repository.findOne(id);
        repository.delete(test);
        Calendar deletedCalendar = repository.findOne(id);
        Assert.assertNull(deletedCalendar);


    }
}
