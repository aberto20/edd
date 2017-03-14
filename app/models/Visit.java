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
public class Visit extends Model {
    @Id
    public long id ;
    public Date date;
    public String famillyWork="";
    public boolean field=false;
    public boolean cultivated=false;
    public String fieldHolder="";
    public boolean house=false;
    public String houseHolder="";
    public String fatherAltitude="";
    public String matherAltitude="";
    public String doneBy="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, Visit> find = new Model.Finder<Long,Visit>(Long.class,Visit.class);
}
