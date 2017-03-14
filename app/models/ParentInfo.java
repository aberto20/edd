package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by edson on 2/17/17.
 */
@Entity
public class ParentInfo extends Model {
    @Id
    public long id ;
    public String fatherNames="";
    public String fatherStatus="";
    public String matherNames="";
    public String matherStatus="";
    public String nearestParent="";
    public String others="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, ParentInfo> find = new Model.Finder<Long,ParentInfo>(Long.class,ParentInfo.class);
    public static List<ParentInfo>all(){
        return find.all();
    }

}
