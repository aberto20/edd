package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by edson on 2/17/17.
 */
@Entity
public class Child extends Model {
    @Id
    public long id;
    public String firstName="";
    public String lastName="";
    public String sureName="";
    public String province="";
    public String district="";
    public String sector="";
    public String cellure="";
    public Date dob;
    public String photo;
    public String gender;
    public double weight=0;
    public double height=0;
    public String nationId="0";
    public boolean deleteStatus=false;
    public boolean isLeft=false;
    public Timestamp leftTime;

    public String doneBy="";
    public Timestamp doneAt=new Timestamp(new Date().getTime());

    public static Model.Finder<Long, Child> find = new Model.Finder<Long,Child>(Long.class,Child.class);
}
