package LifeScheduler.Repository;

import LifeScheduler.App;
import LifeScheduler.Domain.Address;
import LifeScheduler.Domain.ContactInformation;
import LifeScheduler.Domain.Family;
import LifeScheduler.Domain.Statistics;
import LifeScheduler.conf.factory.AddressFactory;
import LifeScheduler.conf.factory.ContactInformationFactory;
import LifeScheduler.conf.factory.FamilyFactory;
import LifeScheduler.conf.factory.StatisticsFactory;
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
public class FamilyCrudTest
{
    @Autowired
    FamilyRepository repository;
    String id;

    Family family;
    String name,surname,levelOfImportance,relation;
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
        relation = "Second Cousin";

        family = FamilyFactory.createFamily("1", name, surname, address, contactInformation, personStats, levelOfImportance, relation);

        repository.save(family);
        id=family.getPersonId();
        Assert.assertNotNull(family.getPersonId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Family test = repository.findOne(id);
        Assert.assertNotNull(test.getPersonId());
        Assert.assertEquals("Hammond Street", family.getAddress().getStreetName());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Family test = repository.findOne(id);
        repository.delete(test);
        Family deletedFamily = repository.findOne(id);
        Assert.assertNull(deletedFamily);
    }

}
