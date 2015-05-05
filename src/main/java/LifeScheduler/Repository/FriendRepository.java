package LifeScheduler.Repository;

import LifeScheduler.Domain.Friend;
import LifeScheduler.Domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Michael on 05/05/2015.
 */
public interface FriendRepository extends CrudRepository<Friend,String>
{
    public Friend findById(String id);
}
