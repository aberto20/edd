package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by edson on 2/17/17.
 */
@Entity
public class Role extends Model {
    @Id
    public long id;
    public String name="";

    public static Model.Finder<Long, Role> find = new Model.Finder<Long,Role>(Long.class,Role.class);
}
