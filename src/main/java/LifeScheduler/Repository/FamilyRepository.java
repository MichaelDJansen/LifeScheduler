package LifeScheduler.Repository;

import LifeScheduler.Domain.Family;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Michael on 05/05/2015.
 */
public interface FamilyRepository extends CrudRepository<Family,String>
{
    public Family findById(String id);
}
