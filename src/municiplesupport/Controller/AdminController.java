package municiplesupport.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import municiplesupport.AddressCollection;
import municiplesupport.DataCollectionClass.HospitalDataTacker;
import municiplesupport.Database.Database;
import municiplesupport.Person;
import municiplesupport.PersonNameSetter;
import municiplesupport.RelativeDataTacker;
import municiplesupport.SchemeDataTaker;


public class AdminController {

    private Database db;

    public AdminController() {
        db = new Database();
    }

    public ArrayList<PersonNameSetter> getPerson() {
        ArrayList<PersonNameSetter> pr = new ArrayList<>();
        String sql = "select Person_id,Ward_id,House_no,Address,relation,Person_name,Gender,Disability from Person";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                PersonNameSetter prs = new PersonNameSetter();
                prs.setId(rs.getString("Person_id"));
                prs.setWard_no(rs.getString("Ward_id"));
                prs.setHouse_no(rs.getString("House_no"));
                prs.setAddress(rs.getString("Address"));
                prs.setRelation(rs.getString("relation"));
                prs.setName(rs.getString("Person_name"));
                prs.setGender(rs.getString("Gender"));
                prs.setDisability(rs.getString("Disability"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    /* public void approveUser(String uname) {
     String sql = "update login set isverified=TRUE where username='" + uname + "'";
     db.update(sql);

     }

     public void rejectUser(String uname) {
     String sql = "delete from login where username='" + uname + "'";
     db.update(sql);
     }*/
    public void insertaddress(AddressCollection p) {
        String sql = "insert into Address(Ward_id,Member_name,contact_no,House_no,Owner_name,house_Address) values('" + p.getWardNo() + "','" + p.getMemberName() + "','" + p.getContactNo() + "','" + p.getHouseNo() + "','" + p.getHouseowner() + "','" + p.getAddress() + "')";
        db.insert(sql);
    }

    public void insertScheme(SchemeDataTaker p) {
        String sql = "insert into Scheme_Catagory(Scheme_name,Disability,Scheme_criteria,Amount) values('" + p.getScheme_catagory() + "','" + p.getDisability() + "','"+p.getScheme_criteria()+"','"+p.getAmount()+"')";
        db.insert(sql);
    }

    public ArrayList<SchemeDataTaker> getScheme() {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String sql = "select Scheme_Name,Disability,Scheme_criteria,Amount from Scheme_Catagory";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setScheme_catagory(rs.getString("Scheme_name"));
                prs.setDisability(rs.getString("Disability"));
                prs.setScheme_criteria(rs.getString("Scheme_criteria"));
                prs.setAmount(rs.getString("Amount"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public boolean validateAddDetails(AddressCollection p) {
       
        String sql = "select Ward_id,house_no from Address where Ward_id=" + p.getWardNo() + " and House_no=" + p.getHouseNo() + "";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean ValidateSchemeAlreadyExists(SchemeDataTaker p) {
        String sql = "select * from Scheme_Catagory where Scheme_name='"+ p.getScheme_catagory()+ "' and Disability='" + p.getDisability() + "'";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public boolean ValidateHospitalAlreadyExists(HospitalDataTacker p) {
        String sql = "select * from Hospital where Hospital_name='"+ p.getHospitalName()+ "' and Disability='" + p.getDisability() + "' and Place='"+p.getPlace()+"'";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     
    public void insertHospital(HospitalDataTacker p) {
        String sql = "insert into Hospital(Hospital_name,Disability,District,Place,About) values('" + p.getHospitalName() + "','" + p.getDisability() + "','"+p.getDisctrict()+"','"+p.getPlace()+"','"+p.getAbout()+"')";
        db.insert(sql);
    }
    
      public ArrayList<HospitalDataTacker> getHospital() {
        ArrayList<HospitalDataTacker> pr = new ArrayList<>();
        String sql = "select Hospital_name,Disability,District,Place,About from Hospital";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                HospitalDataTacker prs = new HospitalDataTacker();
                prs.setHospitalName(rs.getString("Hospital_name"));
                prs.setDisability(rs.getString("Disability"));
                prs.setDisctrict(rs.getString("District"));
                prs.setPlace(rs.getString("Place"));
                prs.setAbout(rs.getString("About"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
      
       public ArrayList<AddressCollection> getDetails(PersonNameSetter b) {
           System.out.println(b.getWard_no());
           
           //int wn=(int)b.getWard_no();
        ArrayList<AddressCollection>pr=new ArrayList<AddressCollection>();
        String sql ="select Ward_id,Member_name,contact_no,House_no,Owner_name,house_Address from Address where Ward_id="+ b.getWard_no() + " and House_no=" +b.getHouse_no()+ "";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                AddressCollection prs = new AddressCollection();
                prs.setWardNo(rs.getString("Ward_id"));
                prs.setHouseNo(rs.getString("House_no"));
                prs.setAddress(rs.getString("house_Address"));
                prs.setContactNo(rs.getString("contact_no"));
                prs.setHouseowner(rs.getString("Owner_name"));
                prs.setMemberName(rs.getString("Member_name"));
                pr.add(prs);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
        public void DeleteHospital(String name, String disability) {
        String sql ="delete from Hospital where Hospital_name='"+name+"' and Disability='"+disability+"'"; 
        db.update(sql);
    }
       public void DeleteUsername(PersonNameSetter p) {
        String sql ="delete from login where login_id in(select Person_id from Person where Ward_id='"+p.getWard_no() +"' and House_no='"+p.getHouse_no()+"')";
        db.update(sql);
    }
        public void DeletePerson(PersonNameSetter p) {
        String sql ="delete from Person where Ward_id='"+p.getWard_no() +"' and House_no='"+p.getHouse_no()+"'";
        db.update(sql);
    }
         public void DeleteAddress(PersonNameSetter p) {
             String sql ="delete from Address where Ward_id='"+p.getWard_no() +"' and House_no='"+p.getHouse_no()+"'";
        db.update(sql);
    }
         public void DeleteRelative(PersonNameSetter p) {
             String sql ="delete from Relative where Person_id in(select Person_id from Person where Ward_id='"+p.getWard_no() +"' and House_no='"+p.getHouse_no()+"')";
        db.update(sql);
         }

    public void DeleteScheme(String name, String disability) {
        String sql="delete from Scheme_catagory where Scheme_name='"+name+"' and Disability='"+disability+"'";
        db.update(sql);
    }

    public ArrayList<SchemeDataTaker> getRequestScheme(String name,String Disability) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String a="Request";
        String sql = "select Person_id,scheme_name,Amount,Status,Disability from Agree_scheme where scheme_name='"+name+"' and Disability='"+Disability+"' and Status='"+a+"'and Status='"+a+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setAmount(rs.getString("Amount"));
                prs.setDisability(rs.getString("Disability"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setStatus(rs.getString("Status"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public void AllowSchemeAdmin(String id) {
        String a="Accept";
        String sql="Update Agree_scheme set Status='"+a+"'";
        db.update(sql);
    }
    
     public ArrayList<SchemeDataTaker> getAcceptScheme(String name,String Disability) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String a="Accept";
        String sql = "select Person_id,scheme_name,Amount,Status,Disability,Date from Agree_scheme where scheme_name='"+name+"' and Disability='"+Disability+"' and Status='"+a+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setAmount(rs.getString("Amount"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setStatus(rs.getString("Status"));
                prs.setDisability(rs.getString("Disability"));
                prs.setDate(rs.getString("Date"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
      
      public ArrayList<SchemeDataTaker> getRejectScheme(String name,String Disability) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String a="Reject";
        String sql = "select Person_id,scheme_name,Amount,Status,Disability,Date from Agree_scheme where scheme_name='"+name+"' and Disability='"+Disability+"' and Status='"+a+"'and Status='"+a+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setAmount(rs.getString("Amount"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setDisability("Disability");
                prs.setStatus(rs.getString("Status"));
                prs.setDate(rs.getString("Date"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
     public void RejectSchemeAdmin(String id) {
        String a="Reject";
        String sql="Update Agree_scheme set Status='"+a+"'";
        db.update(sql);
       
    }

   public ArrayList<SchemeDataTaker> getAdminRequestScheme(String ward,String house) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String a="Request";
        String sql = "select Person_id,scheme_name,Amount,Status,Disability from Agree_scheme where Person_id in(select Person_id from Person where Ward_id='"+ward+"' and House_no='"+house+"' and Status='"+a+"')";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setAmount(rs.getString("Amount"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setStatus(rs.getString("Status"));
                prs.setDisability(rs.getString("Disability"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public ArrayList<SchemeDataTaker> getAdminAcceptScheme(String ward,String house) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String a="Accept";
        String sql = "select Person_id,scheme_name,Amount,Status,Disability,Date from Agree_scheme where Person_id in(select Person_id from Person where Ward_id='"+ward+"' and House_no='"+house+"' and Status='"+a+"')";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setAmount(rs.getString("Amount"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setStatus(rs.getString("Status"));
                prs.setDate(rs.getString("Date"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

     public ArrayList<SchemeDataTaker> getAdminRejectScheme(String ward,String house) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        String a="Reject";
        String sql = "select Person_id,scheme_name,Amount,Status,Disability from Agree_scheme where Person_id in(select Person_id from Person where Ward_id='"+ward+"' and House_no='"+house+"' and Status='"+a+"')";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setAmount(rs.getString("Amount"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setStatus(rs.getString("Status"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public ArrayList<PersonNameSetter> getPersonInformation() {
         ArrayList<PersonNameSetter> pr = new ArrayList<>();
        String sql = "select Person_id,Ward_id,House_no,Address,relation,Person_name,Gender,Disability from Person";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                PersonNameSetter prs = new PersonNameSetter();
                prs.setId(rs.getString("Person_id"));
                prs.setName(rs.getString("Person_name"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
    
    public ArrayList<SchemeDataTaker> getPersonPayment(String id) {
         ArrayList<SchemeDataTaker> pr = new ArrayList<>();
         String a="Accept";
        String sql = "select Person_id,scheme_name,Amount,Date from Agree_scheme where Person_id='"+id+"' and Status='"+a+"'";
        String sq="select sum(Amount) from Agree_scheme where Person_id='"+id+"'";
        ResultSet rs = db.execQuery(sql);
        ResultSet r=db.execQuery(sq);
        try {

            while (rs.next()) {
                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("Person_id"));
                prs.setScheme_catagory(rs.getString("scheme_name"));
                prs.setAmount(rs.getString("Amount"));
                prs.setDate(rs.getString("Date"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

   public ArrayList<RelativeDataTacker> getRelative(String id) {
         ArrayList<RelativeDataTacker> pr = new ArrayList<>();
        String sql = "select Name,Contact_no,Address,relation from Relative where Person_id='"+id+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                RelativeDataTacker prs = new RelativeDataTacker();
                prs.setLblName(rs.getString("Name"));
                prs.setLblAddress(rs.getString("Address"));
                prs.setLblContact_No(rs.getString("Contact_no"));
                prs.setLblRelation(rs.getString("relation"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public PersonNameSetter GetPerson_img(String id) {
    PersonNameSetter pr = new PersonNameSetter();
        String sql = "select Person_image,id_proof,medical_proof from Person where Person_id='"+id+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                PersonNameSetter prs = new PersonNameSetter();
                prs.setPicture(rs.getBytes("Person_image"));
                prs.setIdpicture(rs.getBytes("id_proof"));
                prs.setMedicalpicture(rs.getBytes("medical_proof"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
       }

    public void insertDate(String id, String dat, String name) {
         String sql = "Update Agree_Scheme set Date='"+dat+"' where person_id='"+id+"' and scheme_name='"+name+"'";
        db.insert(sql);
    }

    public void DeleteBank(PersonNameSetter p) {
        System.out.println(p.getName());
        String sql ="delete from Bank where name='"+p.getName()+"'";
        db.update(sql);
    }
    public ArrayList<PersonNameSetter> getsPerson() {
        ArrayList<PersonNameSetter> pr = new ArrayList<>();
        String sql = "select Person_id,Ward_id,House_no,Person_image,Address,relation,Person_name,Gender,Disability from Person";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                PersonNameSetter prs = new PersonNameSetter();
                prs.setId(rs.getString("Person_id"));
                prs.setWard_no(rs.getString("Ward_id"));
                prs.setHouse_no(rs.getString("House_no"));
                prs.setAddress(rs.getString("Address"));
                prs.setRelation(rs.getString("relation"));
                prs.setName(rs.getString("Person_name"));
                prs.setGender(rs.getString("Gender"));
                prs.setDisability(rs.getString("Disability"));
                prs.setPicture(rs.getBytes("Peson_image"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

}    


   

