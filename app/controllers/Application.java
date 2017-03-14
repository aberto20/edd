package controllers;

import models.*;
import org.joda.time.DateTime;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Enfants De Dieu Monitoring System."));
    }
    public static Result dashbord() {
        if (session("userId")!=null) {
          SystemUser user= SystemUser.findbyusername(session("userId"));
          Employee employee=Employee.find.where().eq("system_user_id",user.id).findUnique();
            return ok(dashboard.render(employee,"dashbord page"));
        }else {
            return redirect("/");
        }
    }
    public static Result allEmployee(){
        List<Employee> employee=Employee.all();
       return ok(Json.toJson(employee));
    }
    public static Result newChildRegistration(){
        if (session("userId")!=null) {
            return ok(childrenRegistration.render());
        }else {
            return redirect("/");
        }

    }
    public static Result allParents(){
        if (session("userId")!=null) {
            return ok(parent.render());
        }else {
            return redirect("/");
        }

    }
    public static Result allNeighbours(){
        if (session("userId")!=null) {
            return ok(neighbour.render());
        }else {
            return redirect("/");
        }

    }
    public static Result viewEmployee(){
        if (session("userId")!=null) {
            return ok(employeeRegistration.render());
        }else {
            return redirect("/");
        }

    }
    public static Result listConsultation(){
        if (session("userId")!=null) {
            return ok(clinic.render());
        }else {
            return redirect("/");
        }

    }
    public static Result NeighboursLoad(){
        List<Neighbours> n=Neighbours.find.all();
        return ok(Json.toJson(n));

    }
    public static Result parentById(long id){
        ParentInfo parent=ParentInfo.find.ref(id);
        return ok(Json.toJson(parent));
    }
    public static Result neighbourById(long id){
        Neighbours neighbours=Neighbours.find.ref(id);
        return ok(Json.toJson(neighbours));
    }
    public static Result UpdateneighbourById(long id){
        try{
            Form<Neighbours>neighboursForm=Form.form(Neighbours.class).bindFromRequest();
            Neighbours neighbours=neighboursForm.get();
            Neighbours neighbours1=Neighbours.find.ref(id);
            neighbours1.neighbNames=neighbours.neighbNames;
            neighbours1.save();
            return ok("ok");
        }catch (Exception e){
            return ok(e.getMessage());
        }

    }
    public static Result UpdateparentById(long id){
        try{
            Form<ParentInfo>parentInfoForm=Form.form(ParentInfo.class).bindFromRequest();
            ParentInfo parentInfo=parentInfoForm.get();
            ParentInfo parent=ParentInfo.find.ref(id);
            parent.fatherNames=parentInfo.fatherNames;
            parent.matherNames=parentInfo.matherNames;
            parent.fatherStatus=parentInfo.fatherStatus;
            parent.matherStatus=parentInfo.matherStatus;
            parent.nearestParent=parentInfo.nearestParent;
            parent.others=parentInfo.others;
            parent.save();
            return ok("ok");
        }catch (Exception e){
            return ok(e.getMessage());
        }

    }
    public static Result childInfo(long id){
        Child children=Child.find.ref(id);
        ParentInfo parentInfo=ParentInfo.find.where().eq("child_id",id).findUnique();
        Siblings siblings=Siblings.find.where().eq("child_id",id).findUnique();
        ChildHistory childHistory=ChildHistory.find.where().eq("child_id",id).findUnique();
        UsageDrugs usageDrugs=UsageDrugs.find.where().eq("child_id",id).findUnique();
        ChildBehavior childBehavior=ChildBehavior.find.where().eq("child_id",id).findUnique();
        Schooling schooling=Schooling.find.where().eq("child_id",id).findUnique();
        Neighbours neighbours=Neighbours.find.where().eq("child_id",id).findUnique();
       return ok(childrenInfo.render(children,parentInfo,siblings,childHistory,usageDrugs,childBehavior,schooling,neighbours));
    }
    public static Result EmployeeById(long id){
        Employee employees=Employee.byId(id);
       return ok(Json.toJson(employees));
    }
    public static Result allChildren(){
        List<ParentInfo> parent=ParentInfo.all();
       return ok(Json.toJson(parent));
    }
    public static Result childById(long id){
        if(id!=0) {
            Child child = Child.find.ref(id);
            return ok(Json.toJson(child));
        }else {
            return ok("error");
        }
    }
    public static Result childStatistic(){
      statisticCh statisticChildren=new statisticCh();
        return ok(Json.toJson(statisticChildren));
    }

    public static Result logout(){
        session().clear();
        return redirect("/");
    }
    public static Result signin(){
        Form<SystemUser> s=Form.form(SystemUser.class).bindFromRequest();
        String userName=s.field("username").value();
        String password=s.field("password").value();
        long count=SystemUser.find.where().eq("user_name",userName).eq("password",password).findRowCount();
        if (count>0){
            SystemUser systemUser=SystemUser.find.where().eq("user_name",userName).findUnique();
            Employee e=Employee.find.where().eq("system_user_id",systemUser.id).findUnique();
            if (e.active){
                session("userId",userName);
                System.out.println(" login successfully");
                return ok("ok");
            }else {
                System.out.println(" login is fail");
                return ok("error");
            }

        }else{
            System.out.println(" login is fail");
            return ok("error");
        }
    }

    public static Result uploadImage(){
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("file");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();

            file.renameTo(new File("public/images/profile", fileName));

            return ok(fileName);
        } else {
            flash("error", "Missing file");
            return ok("Error");
        }
    }
    public static Result usernameExist(String phone){
        int chkphone = Employee.find.where().eq("phone", phone).findRowCount();
        if (chkphone > 0) {
            return ok("phoneExist");
        }else {
            return ok("ok");
        }
    }

    public static Result uploadDocument(){
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart doc = body.getFile("file");
        if (doc != null) {
            String fileName = doc.getFilename();
            String contentType = doc.getContentType();
            File file = doc.getFile();

            file.renameTo(new File("public/documents/", fileName));

            return ok(fileName);

        } else {
            flash("error", "Missing file");
            return ok("Error");
        }
    }
    public static Result employeeRegistration(){
        try {
            Form<Employee> employeeForm = Form.form(Employee.class).bindFromRequest();
            String phone = employeeForm.field("phone").value();
            String username = employeeForm.field("userName").value();
            int chkusername = SystemUser.find.where().eq("user_name", username).findRowCount();
            int chkphone = Employee.find.where().eq("phone", phone).findRowCount();
            if (chkphone > 0) {
                return ok("phoneExist");
            }
            if (chkusername > 0) {
                return ok("usernameExist");
            }

            SystemUser user= SystemUser.findbyusername(session("userId"));
            Employee emp=Employee.find.where().eq("system_user_id",user.id).findUnique();
            Employee employee = employeeForm.get();

            //save System user
            SystemUser s = new SystemUser();
            s.userName = username;
            s.save();
            long userId = SystemUser.find.setMaxRows(1).order().desc("id").findUnique().id;
            Employee e = new Employee();
            e.names = employee.names;
            e.address = employee.address;
            e.documentCertificate = employee.documentCertificate;
            e.phone = employee.phone;
            e.photo = employee.photo;
            e.documentCv = employee.documentCv;
            e.status = "working";
            e.title = employee.title;
            e.systemUser = SystemUser.findbyId(userId);
            e.doneBy=emp.names;

            e.save();
            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result childUpdate(long id){
        try {
            Form<Child> c = Form.form(Child.class).bindFromRequest();

            Child child = c.get();
            SystemUser user= SystemUser.findbyusername(session("userId"));
            Employee employee=Employee.find.where().eq("system_user_id",user.id).findUnique();

            Child e = Child.find.ref(id);
            e.firstName = child.firstName;
            e.lastName = child.lastName;
            e.sureName = child.sureName;
            e.province = child.province;
            e.district = child.district;
            e.sector = child.sector;
            e.cellure = child.cellure;
            e.dob = child.dob;
            if(child.photo!=""){
                e.photo = child.photo;
            }
            if(child.gender!=""){
                e.gender = child.gender;
            }
            e.weight = child.weight;
            e.height = child.height;
            e.nationId = child.nationId;
            e.doneBy=employee.names;
            e.save();
            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result childRegistration2(){
        try {
            Form<Child> c = Form.form(Child.class).bindFromRequest();
            Form<Siblings> siblingsForm = Form.form(Siblings.class).bindFromRequest();
            Form<Neighbours> neighboursForm = Form.form(Neighbours.class).bindFromRequest();
            Form<ChildHistory> childHistoryForm = Form.form(ChildHistory.class).bindFromRequest();
            Form<UsageDrugs> usageDrugsForm = Form.form(UsageDrugs.class).bindFromRequest();

            Siblings siblings=siblingsForm.get();
            Neighbours neighbours=neighboursForm.get();
            ChildHistory childHistory=childHistoryForm.get();
            UsageDrugs usageDrugs=usageDrugsForm.get();

            SystemUser user= SystemUser.findbyusername(session("userId"));
            Employee employee=Employee.find.where().eq("system_user_id",user.id).findUnique();

            String fName = c.field("firstName").value();
            String lName = c.field("lastName").value();
            String fatherNames = c.field("fatherNames").value();
            String fatherStatus = c.field("fatherStatus").value();
            String nearestParent = c.field("nearestParent").value();
            String matherNames = c.field("matherNames").value();
            String matherStatus = c.field("matherStatus").value();
            String others = c.field("others").value();
            int chkuname = Child.find.where().eq("first_name", fName).eq("last_name",lName).findRowCount();

            if (chkuname > 0) {
                return ok("nameExist");
            }

            Child child = c.get();


            Child e = new Child();
            e.firstName = child.firstName;
            e.lastName = child.lastName;
            e.sureName = child.sureName;
            e.province = child.province;
            e.district = child.district;
            e.sector = child.sector;
            e.cellure = child.cellure;
            e.dob = child.dob;
            e.photo = child.photo;
            e.gender = child.gender;
            e.weight = child.weight;
            e.height = child.height;
            e.nationId = child.nationId;
            e.doneBy=employee.names;
            e.save();
            long userId = Child.find.setMaxRows(1).order().desc("id").findUnique().id;


            ParentInfo s = new ParentInfo();
            s.fatherNames = fatherNames;
            s.fatherStatus = fatherStatus;
            s.matherNames = matherNames;
            s.matherStatus = matherStatus;
            s.nearestParent = nearestParent;
            s.others = others;
            s.child = Child.find.byId(userId);

            s.save();

            Siblings siblings1=new Siblings();
            siblings1.siblingNames=siblings.siblingNames;
            siblings1.siblinggender=siblings.siblinggender;
            siblings1.child=Child.find.byId(userId);

            siblings1.save();


            Neighbours neighbours1=new Neighbours();
            neighbours1.neighbNames=neighbours.neighbNames;
            neighbours1.child=Child.find.byId(userId);
            neighbours1.save();

            ChildHistory childHistory1=new ChildHistory();
            childHistory1.a1=childHistory.a1;
            childHistory1.a2=childHistory.a2;
            childHistory1.a3=childHistory.a3;
            childHistory1.a4=childHistory.a4;
            childHistory1.childHistoryother=childHistory.childHistoryother;
            childHistory1.streetLocation=childHistory.streetLocation;
            childHistory1.child=Child.find.byId(userId);
            childHistory1.save();

            UsageDrugs usageDrugs1=new UsageDrugs();
            usageDrugs1.druga1=usageDrugs.druga1;
            usageDrugs1.druga2=usageDrugs.druga2;
            usageDrugs1.drugName1=usageDrugs.drugName1;
            usageDrugs1.drugName2=usageDrugs.drugName2;
            usageDrugs1.drugName3=usageDrugs.drugName3;
            usageDrugs1.drugName4=usageDrugs.drugName4;
            usageDrugs1.usageState1=usageDrugs.usageState1;
            usageDrugs1.usageState2=usageDrugs.usageState2;
            usageDrugs1.usageState3=usageDrugs.usageState3;
            usageDrugs1.usageState4=usageDrugs.usageState4;
            usageDrugs1.usageState5=usageDrugs.usageState5;
            usageDrugs1.other=usageDrugs.other;
            usageDrugs1.child=Child.find.byId(userId);
            usageDrugs1.save();
            String stringMonth="";
            DateTime date=new DateTime();
            if (date.getMonthOfYear()==1){
                stringMonth="Jan";
            }else if (date.getMonthOfYear()==2){
                stringMonth="Feb";
            }else if (date.getMonthOfYear()==3){
                stringMonth="March";
            }else if (date.getMonthOfYear()==4){
                stringMonth="April";
            }else if (date.getMonthOfYear()==5){
                stringMonth="May";
            }else if (date.getMonthOfYear()==6){
                stringMonth="Jun";
            }else if (date.getMonthOfYear()==7){
                stringMonth="Jul";
            }else if (date.getMonthOfYear()==8){
                stringMonth="Aug";
            }else if (date.getMonthOfYear()==9){
                stringMonth="Sept";
            }else if (date.getMonthOfYear()==10){
                stringMonth="Oct";
            }else if (date.getMonthOfYear()==11){
                stringMonth="Nov";
            }else if (date.getMonthOfYear()==12){
                stringMonth="Dec";
            }
            StatisticChild st=StatisticChild.find.where().eq("month",stringMonth).findUnique();
            if (st!=null){
                st.setRegChild(st.regChild+1);
                st.update();
            }else{
                StatisticChild ch=new StatisticChild();
                ch.setRegChild(1);
                ch.setdesertedregChild(0);
                ch.month=stringMonth;
                ch.save();
            }

            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result employeeUpdate(long id){
        try {
            Form<Employee> employeeForm = Form.form(Employee.class).bindFromRequest();
           String username=employeeForm.field("userName").value();
            Employee employee = employeeForm.get();
            Employee e = Employee.find.ref(id);
            //save System user
            SystemUser s = SystemUser.find.where().eq("user_name",e.systemUser.userName).findUnique();
            s.userName = username;
            s.save();
            e.names = employee.names;
            e.address = employee.address;
            e.phone = employee.phone;
            e.status = "working";
            e.title = employee.title;
            e.save();
            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result allConsultation(){
        List<Consultation> consultation=Consultation.find.all();
        return ok(Json.toJson(consultation));
    }
    public static Result updateConsult(long id){
        Form<Consultation> consForm = Form.form(Consultation.class).bindFromRequest();
        long chId=Long.parseLong(consForm.field("child").value());
        Consultation cons = consForm.get();
        Consultation consultation=Consultation.find.byId(id);
        consultation.weight=cons.weight;
        consultation.complains=cons.complains;
        consultation.update();
        Child child=Child.find.byId(chId);
        child.weight=cons.weight;
        child.update();
        return ok("ok");
    }
    public static Result saveConsult(){
        try {
            Form<Consultation> consForm = Form.form(Consultation.class).bindFromRequest();
            long chId=Long.parseLong(consForm.field("child").value());
            Consultation cons = consForm.get();
             Consultation consultation=new Consultation();
            consultation.child=Child.find.byId(chId);
            consultation.complains=cons.complains;
            consultation.weight=cons.weight;
            consultation.save();
            Child child=Child.find.byId(chId);
            child.weight=cons.weight;
            child.update();
            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result employeeDelete(long id){
        try {
            Employee e = Employee.find.ref(id);
            e.active = false;
            e.save();
            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result childDelete(long id){
        try {

            Child e = Child.find.ref(id);
            if(e!=null) {
                e.deleteStatus=true;
                e.save();
            }

            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }
    public static Result employeeActivate(long id){
        try {
            Employee e = Employee.find.ref(id);
            e.active = true;
            e.save();
            return ok("ok");
        }
        catch (Exception e){
            return ok(e.getMessage());
        }
    }

}
