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
public class BackHome extends Model {
    @Id
    public long id;
    public String province="";
    public String district="";
    public String sector="";
    public String cellure="";
    public String receivedBy="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, BackHome> find = new Model.Finder<Long,BackHome>(Long.class,BackHome.class);
}
