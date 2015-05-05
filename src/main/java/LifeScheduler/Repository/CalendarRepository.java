package LifeScheduler.Repository;

import LifeScheduler.Domain.Calendar;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Michael on 05/05/2015.
 */
public interface CalendarRepository extends CrudRepository<Calendar,String>
{
    public Calendar findById(String id);
}
