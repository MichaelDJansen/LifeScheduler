package LifeScheduler.Domain;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 17/04/2015.
 */
public class Task
{
    //@Id
    //@Auto
    private String id;
    private String taskName;
    private Time startTime;
    private Time finishTime;
    private Date date;
    private String description;
}
