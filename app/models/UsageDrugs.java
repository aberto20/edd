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
public class UsageDrugs extends Model {
    @Id
    public long id;
    public String drugName1="chancre";
    public String drugName2="Mayirungi-Essance";
    public String drugName3="Colle";
    public String drugName4="heroin";
    public String other="";
    public String usageState1="";
    public String usageState2="";
    public String usageState3="";
    public String usageState4="";
    public String usageState5="";
    public String q1="Since when ?";
    public String druga1="";
    public String q2="Under what circumstances ?";
    public String druga2="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, UsageDrugs> find = new Model.Finder<Long,UsageDrugs>(Long.class,UsageDrugs.class);
}
