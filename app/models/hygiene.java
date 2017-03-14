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
public class hygiene extends Model {
    @Id
    public long id;
    public String onBody="";
    public String onClothes="";
    public String sugestion="";
    public String comment="";
    public String doneBy="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, hygiene> find = new Model.Finder<Long,hygiene>(Long.class,hygiene.class);
}
