package LifeScheduler.Services.Impl;

import LifeScheduler.Domain.Calendar;
import LifeScheduler.Repository.CalendarRepository;
import LifeScheduler.Services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Michael on 05/05/2015.
 */
@Service
public class CalendarServiceImpl implements CalendarService
{
    @Autowired
    CalendarRepository repository;

    public ArrayList<Calendar> getCalendars()
    {
        ArrayList<Calendar> allCalendars = new ArrayList<Calendar>();

        Iterable<Calendar> calendars = repository.findAll();
        for(Calendar calendar:calendars)
        {
            allCalendars.add(calendar);
        }
        return allCalendars;
    }
}
