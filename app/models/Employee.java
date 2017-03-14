package models;

import play.db.ebean.Model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by edson on 2/17/17.
 */
@Entity
public class Employee extends Model {
    @Id
    public long id;
    public String names="";
    public String address="";
    public String phone="";
    public String title="";
    public String photo="";
    public String documentCv="";
    public String documentCertificate="";
    public boolean active=false;
    public String status="";
    public String doneBy="";

    @ManyToOne(cascade = CascadeType.ALL)
    public SystemUser systemUser;



    public static Model.Finder<Long, Employee> find = new Model.Finder<Long,Employee>(Long.class,Employee.class);
    public static List<Employee> all(){
        return (find.all());
    }
    public static Employee byId(long id){
        return (find.ref(id));
    }
}
