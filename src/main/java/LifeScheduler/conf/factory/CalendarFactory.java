package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Calendar;
import LifeScheduler.Domain.Task;
import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */
public class CalendarFactory
{
    public static Calendar createCalendar(String personId,ArrayList<Task> events)
    {
        Calendar calendar = new Calendar.Builder(personId,events).build();
        return calendar;
    }
}
