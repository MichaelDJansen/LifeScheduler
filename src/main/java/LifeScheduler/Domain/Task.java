package LifeScheduler.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Michael on 17/04/2015.
 */

@Entity
public class Task implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String taskId;
    private String taskName;
    private Time startTime;
    private Time finishTime;
    private Date date;
    private String description;

    Task(Builder builder)
    {
        taskId = builder.taskId;
        taskName = builder.taskName;
        startTime = builder.startTime;
        finishTime = builder.finishTime;
        date = builder.date;
        description = builder.description;
    }

    public static class Builder{

        private String taskId;
        private String taskName;
        private Time startTime;
        private Time finishTime;
        private Date date;
        private String description;

        public Builder(String taskId,String taskName,Time startTime,Time finishTime,Date date) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.startTime = startTime;
            this.finishTime = finishTime;
            this.date = date;
        }

        public Builder description(String value){
            this.description = value;
            return this;
        }

        public Builder copy(Task value){
            this.taskId = value.taskId;
            this.taskName = value.getTaskName();
            this.startTime = value.getStartTime();
            this.finishTime = value.getFinishTime();
            this.date = value.getDate();
            this.description = value.getDescription();
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getFinishTime() {
        return finishTime;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!taskId.equals(task.taskId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return taskId.hashCode();
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
