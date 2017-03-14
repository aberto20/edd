package models;

import org.joda.time.DateTime;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by edson on 2/25/17.
 */
@Entity
public class StatisticChild extends Model {
    @Id
    public long id;
    public double regChild=0;
    public double desertedregChild=0;
    public String month="";
    public DateTime doneAt=new DateTime();

    public static Model.Finder<Long, StatisticChild> find = new Model.Finder<Long,StatisticChild>(Long.class,StatisticChild.class);
    public static List<StatisticChild> all()            { return(find.all()); }

    public double getRegChild() {
        return regChild;
    }

    public void setRegChild(double c) {
        this.regChild = c;
    }

    public double getdesertedregChild() {
        return desertedregChild;
    }

    public void setdesertedregChild(double d) {
        this.desertedregChild = d;
    }


}

