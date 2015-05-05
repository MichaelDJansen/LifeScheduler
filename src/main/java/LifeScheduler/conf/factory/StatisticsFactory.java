package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Statistics;

import java.sql.Time;

/**
 * Created by Michael on 05/05/2015.
 */
public class StatisticsFactory
{
    public static Statistics createStatistics(String personId,Time timeSpentTogether,int nrInteractions)
    {
        Statistics statistics = new Statistics.Builder(personId,timeSpentTogether,nrInteractions).build();

        return statistics;
    }
}
