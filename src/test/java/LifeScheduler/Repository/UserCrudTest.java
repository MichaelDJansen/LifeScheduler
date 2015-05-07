package LifeScheduler.Repository;

import LifeScheduler.App;
import LifeScheduler.Domain.*;
import LifeScheduler.conf.factory.AddressFactory;
import LifeScheduler.conf.factory.ContactInformationFactory;
import LifeScheduler.conf.factory.FamilyFactory;
import LifeScheduler.conf.factory.StatisticsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 07/05/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class UserCrudTest extends AbstractTestNGSpringContextTests
{
    private String id;

    @Autowired
    private UserRepository repository;

    //User
    User user;

    String userId;
    Calendar calendar;
    ArrayList<Hobby> hobbies;
    ArrayList<Person> familyAndFriends;
    ArrayList<Person> favourites;
    Occupation occupation;

    //Hobby
    Hobby hobby1;
    String hobbyId;
    String hobbyName;
    int numDaysOccupied;
    Time timeSpentPerActivity;

    //Task
    ArrayList<Task> events;
    Task task1;
    String taskId,taskName,description;
    Time startTime,finishTime;
    Date date;

    //Person
    Family family;
    String name,surname,levelOfImportance,relation;
    Address address;
    ContactInformation contactInformation;
    Statistics personStats;

    //Occupation
    String occupationName;
    Time start;
    Time finish;
    int nrDaysOccupied;

    @Test
    public void create() throws Exception {

        hobbies = new ArrayList<Hobby>();
        familyAndFriends = new ArrayList<Person>();
        favourites = new ArrayList<Person>();
        events = new ArrayList<Task>();

        taskId = "1";
        taskName = "Take out trash";
        description = "Take out the trash once you get home";
        startTime = new Time(15,30,00);
        finishTime = new Time(15,32,00);
        date = new Date(2015,10,11);

        task1 = new Task.Builder(taskId,taskName,startTime,finishTime,date).description(description).build();

        events.add(task1);

        hobbyId = "155";
        hobbyName = "Dragonboating";
        nrDaysOccupied = 3;
        timeSpentPerActivity = new Time(01,30,00);

        hobby1 = new Hobby.Builder(hobbyId,hobbyName,nrDaysOccupied,timeSpentPerActivity).build();

        hobbies.add(hobby1);

        name = "Peter";
        surname = "Johnson";
        levelOfImportance = "High";
        address =  AddressFactory.createAddress("Hammond Street", "55", "Hadefield", "7500");
        contactInformation = ContactInformationFactory.createContactInformation("0756685697", "Peter Johnson", "@PeterJ");
        personStats = StatisticsFactory.createStatistics("1", new Time(00, 50, 90), 5);
        relation = "Second Cousin";

        family = FamilyFactory.createFamily("1", name, surname, address, contactInformation, personStats, levelOfImportance, relation);

        familyAndFriends.add(family);
        favourites.add(family);

        userId = "1";
        calendar = new Calendar.Builder("1",events).build();

        name = "Software Developer";
        start = new Time(8,30,00);
        finish = new Time(16,30,00);
        nrDaysOccupied = 5;

        occupation = new Occupation.Builder(occupationName,start,finish,nrDaysOccupied).build();

        user = new User.Builder(userId,calendar,hobbies,familyAndFriends,favourites,occupation).build();

        repository.save(user);
        id = user.getUserId();
        Assert.assertNotNull(user.getUserId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User test = repository.findOne(id);
        Assert.assertNotNull(test.getUserId());
        Assert.assertEquals("Take out trash", test.getCalendar().getEvents().get(0).getTaskName());
        Assert.assertTrue(test.getCalendar().getEvents().size() == 2);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User test = repository.findOne(id);
        repository.delete(test);
        User deletedUser = repository.findOne(id);
        Assert.assertNull(deletedUser);


    }

}
