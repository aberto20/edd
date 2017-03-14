package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by edson on 2/17/17.
 */
@Entity
public class ChildHistory extends Model {
    @Id
    public long id;
    public String q1="When the child has left the family?";
    public String a1="";
    public String q2="When did he come to the project?";
    public String a2="";
    public String q3="Has he attended another center?if yes which one?";
    public String a3="";
    public String q4= "Reasons to go on the street";
    public String a4="";
    public String childHistoryother="";
    public String streetLocation="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, ChildHistory> find = new Model.Finder<Long,ChildHistory>(Long.class,ChildHistory.class);
}
