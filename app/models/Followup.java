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
public class Followup extends Model {
    @Id
    public long id;
    public boolean isStudy=false;
    public boolean isStudyFinish=false;
    public boolean hasGotJob=false;
    public String jobType="";
    public Date date;

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, Followup> find = new Model.Finder<Long,Followup>(Long.class,Followup.class);
}
