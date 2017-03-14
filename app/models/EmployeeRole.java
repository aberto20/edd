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
public class EmployeeRole extends Model {
    @Id
    public long id;
    @ManyToOne(cascade = CascadeType.ALL)
    public Role role;
    @ManyToOne(cascade = CascadeType.ALL)
    public Employee employee;

    public Timestamp doneAt=new Timestamp(new Date().getTime());

    public static Model.Finder<Long, EmployeeRole> find = new Model.Finder<Long,EmployeeRole>(Long.class,EmployeeRole.class);
}
