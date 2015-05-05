package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Task;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 05/05/2015.
 */
public class TaskFactory
{
    public static Task createTask(String personId,String taskName,Time startTime,Time finishTime,Date date)
    {
        Task task = new Task.Builder(personId, taskName, startTime, finishTime, date).build();

        return task;
    }
}
