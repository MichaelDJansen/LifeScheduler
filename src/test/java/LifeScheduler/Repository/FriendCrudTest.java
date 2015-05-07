package LifeScheduler.Repository;

import LifeScheduler.App;
import LifeScheduler.Domain.*;
import LifeScheduler.conf.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;

/**
 * Created by Michael on 07/05/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class FriendCrudTest
{
    @Autowired
    FriendRepository repository;
    String id;

    Friend friend;
    String name,surname,levelOfImportance,meetingPlace;
    Address address;
    ContactInformation contactInformation;
    Statistics personStats;

    @Test
    public void create() throws Exception {

        name = "Peter";
        surname = "Johnson";
        levelOfImportance = "High";
        address =  AddressFactory.createAddress("Hammond Street", "55", "Hadefield", "7500");
        contactInformation = ContactInformationFactory.createContactInformation("0756685697", "Peter Johnson", "@PeterJ");
        personStats = StatisticsFactory.createStatistics("1", new Time(00, 50, 90), 5);
        meetingPlace = "School";

        friend = FriendFactory.createFamily("1", name, surname, address, contactInformation, personStats, levelOfImportance, meetingPlace);

        repository.save(friend);
        id=friend.getPersonId();
        Assert.assertNotNull(friend.getPersonId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Friend test = repository.findOne(id);
        Assert.assertNotNull(test.getPersonId());
        Assert.assertEquals("Hammond Street", friend.getAddress().getStreetName());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Friend test = repository.findOne(id);
        repository.delete(test);
        Friend deletedFamily = repository.findOne(id);
        Assert.assertNull(deletedFamily);
    }

}
