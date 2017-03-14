package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by edson on 2/18/17.
 */
@Entity
public class SystemUser extends Model {
    @Id
    public long id;
    public String userName="";
    public String password="kigali";

    public Timestamp doneAt=new Timestamp(new Date().getTime());



    public static Model.Finder<Long, SystemUser> find = new Model.Finder<Long,SystemUser>(Long.class,SystemUser.class);
    public static SystemUser findbyId(long id){
        return (find.ref(id));
    }
    public static SystemUser findbyusername(String username){
        return (find.where().eq("user_name",username).findUnique());
    }

}
