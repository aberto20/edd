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
public class Schooling extends Model {
    @Id
    public long id;
    public String studiesLevel="";
    public String schoolName="";
    public boolean readAndWrite=false;
    public boolean currentCapacity=false;
    public boolean rescolarisable=false;
    public boolean learningDifficulties=false;
    public boolean refuseSchool=false;
    public String refuseSchoolName="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, Schooling> find = new Model.Finder<Long,Schooling>(Long.class,Schooling.class);
}
