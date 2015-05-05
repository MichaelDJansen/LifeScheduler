package LifeScheduler.Repository;

import LifeScheduler.Domain.User;
import org.apache.coyote.http11.AbstractNioInputBuffer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */
public interface UserRepository extends CrudRepository<User,String>
{
    User findById(String id);
}
