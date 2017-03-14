package models;


import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by edson on 2/26/17.
 */
public class statisticCh {
    public String[] months;

    public double [][] data;
    public double [][] data1;
    public DateTime date=new DateTime();

    public statisticCh(){
        List<StatisticChild> statisticChildren=StatisticChild.all();
        int size = statisticChildren.size();
        months = new String[size];
        data = new double[1][size];
        data1 = new double[1][size];
        int i = 0;
            for (StatisticChild ch:statisticChildren) {
                if (ch.doneAt.getYear() == date.getYear()) {
                    months[i] = ch.month;
                    data[0][i] = ch.regChild;
                    data1[0][i] = ch.desertedregChild;

                    i++;
                }
            }


    }
}
