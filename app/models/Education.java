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
public class Education extends Model {
    @Id
    public long id;
    public String subject="";
    public String level="";
    public String yearClass="";
    public double marks=0;
    public String term="";
    public String schoolYear="";
    public String schoolReport="";
    public String doneBy="";

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    @ManyToOne(cascade = CascadeType.ALL)
    public Child child;

    public static Model.Finder<Long, Education> find = new Model.Finder<Long,Education>(Long.class,Education.class);

}
