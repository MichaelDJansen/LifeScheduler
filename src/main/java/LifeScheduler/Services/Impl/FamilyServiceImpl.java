package LifeScheduler.Services.Impl;

import LifeScheduler.Domain.Family;
import LifeScheduler.Domain.Friend;
import LifeScheduler.Repository.FamilyRepository;
import LifeScheduler.Repository.FriendRepository;
import LifeScheduler.Services.FamilyService;
import LifeScheduler.Services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */
@Service
public class FamilyServiceImpl implements FamilyService
{
    @Autowired
    FamilyRepository repository;

    public ArrayList<Family> getFamily()
    {
        ArrayList<Family> allFamily = new ArrayList<Family>();

        Iterable<Family> families = repository.findAll();
        for (Family family : families) {
            allFamily.add(family);
        }

        return allFamily;
    }
}
