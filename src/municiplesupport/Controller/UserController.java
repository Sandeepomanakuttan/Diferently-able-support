/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport.Controller;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import municiplesupport.AddressCollection;
import municiplesupport.BankDataTacker;
import municiplesupport.DataCollectionClass.HospitalDataTacker;
import municiplesupport.Database.Database;
import municiplesupport.GetloginData;
import municiplesupport.Person;
import municiplesupport.PersonNameSetter;
import municiplesupport.RelativeDataTacker;
import municiplesupport.SchemeDataTaker;
import municiplesupport.SetUserNamePasswordData;
import municiplesupport.UserProfileFrame;
import municiplesupport.loginData;

/**
 *
 * @author kishore
 */
public class UserController {

    private Database db;
    public String ward,house,address,relation,name,gen,Dis,Dof;
    public byte[] perimage;

    public UserController() {
        db = new Database();
    }

    public void SetUsernamePassword(SetUserNamePasswordData user) {
        String sql = "insert into login(user_name,password)values('" + user.getUsername() + "','" + user.getPassword() + "')";
        db.insert(sql);

    }

    public void insertUser(PersonNameSetter user) {
        String sql = "insert into Person(Ward_id,House_no,Address,relation,Person_name,Gender,Disability,DoB,Person_image,id_proof,medical_proof) values('" + user.getWard_no() + "','"
                + user.getHouse_no() + "','" + user.getAddress() + "','" + user.getRelation() + "','" + user.getName() + "','" + user.getGender() + "','" + user.getDisability() + "','"+user.getDob()+"','"+user.getPicture()+"','"+user.getIdpicture()+"','"+user.getMedicalpicture()+"')";
        db.insert(sql);

    }
    public boolean isUserAlreadyExist(SetUserNamePasswordData user) {
        String sql = "select * from login where user_name='" + user.getUsername() + "' and password='" + user.getPassword() + "'";
        ResultSet rs = db.execQuery(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SetUserNamePasswordData> getLogin(SetUserNamePasswordData prs) {
        ArrayList<SetUserNamePasswordData> pr = new ArrayList<>();
        String sql = "select login_id from login where user_name='" + prs.getUsername() + "' and password='" + prs.getPassword() + "'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                prs.setLogin_id(rs.getString("login_id"));
                System.out.println(prs.getLogin_id());
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public boolean isCheckLoginUserExists(loginData user) {
        String sql = "select * from login where user_name='" + user.getName() + "' and password='" + user.getPass() + "'";
        ResultSet rs = db.execQuery(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean checkPersonInMuniciple(PersonNameSetter p) {
        System.out.println("" + p.getWard_no() + "," + p.getHouse_no());
        String sql = "select Ward_id,house_no from Address where Ward_id=" + p.getWard_no() + " and House_no=" + p.getHouse_no() + "";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkPersonAlreadyExists(PersonNameSetter p) {
        System.out.println("" + p.getWard_no() + "," + p.getHouse_no());
        String sql = "select Ward_id,house_no from Person where Ward_id=" + p.getWard_no() + " and House_no=" + p.getHouse_no() + "";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<PersonNameSetter> CollecteMyInformation(loginData p) {
        ArrayList<PersonNameSetter> pr = new ArrayList<>();
        System.out.println(p.getLogin_id());
        String sql = "select login_id,Ward_id,House_no,Address,relation,Person_name,Gender,Disability from Person where Person_id='"+ p.getLogin_id()+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {

                PersonNameSetter prs = new PersonNameSetter();
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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public ArrayList<SchemeDataTaker> CollecteMyScheme(loginData p) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        System.out.println(p.getLogin_id());
        String sql = "(select Scheme_name,Disability,Scheme_criteria,Amount from scheme_catagory where Disability=(select Disability from person where Person_id=" + p.getLogin_id() + "))";
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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public ArrayList<HospitalDataTacker> CollecteMyHospital(loginData p) {
        ArrayList<HospitalDataTacker> pr = new ArrayList<>();
        //System.out.println(p.getLogin_id());
        String sql = "(select Hospital_name,Disability,District,Place,About from hospital where Disability=(select Disability from person where Person_id=" + p.getLogin_id() + "))";
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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public boolean Exists(PersonNameSetter p) {
        System.out.println("" + p.getWard_no() + "," + p.getHouse_no());
        String sql = "select Ward_id,house_no from Person where Ward_id=" + p.getWard_no() + " and House_no=" + p.getHouse_no() + "";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<loginData> getLoginid(loginData prs) {
        ArrayList<loginData> pr = new ArrayList<>();
        String sql = "select login_id from login where user_name='" + prs.getName() + "' and password='" + prs.getPass() + "'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                prs.setLogin_id(rs.getString("login_id"));
                //System.out.println(prs.getLogin_id());
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
    
     public boolean AgreeUserAlready(String name,String id) {
     String sql = "select person_id,scheme_name from Agree_Scheme where person_id='"+id+"' and scheme_name='"+name+"'";
    ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
    public void AgreeUser(String name,String id,String Amount,String dis) {
        String a="Request";
     String sql = "insert into Agree_Scheme(person_id,scheme_name,Amount,Status,Disability)values('"+id+"','"+name+"','"+Amount+"','"+a+"','"+dis+"')";
     db.insert(sql);

     }
    
     public ArrayList<SchemeDataTaker> CollecteMyAgreedScheme(loginData p) {
        ArrayList<SchemeDataTaker> pr = new ArrayList<>();
        System.out.println(p.getLogin_id());
        String sql = "(select * from Agree_Scheme where person_id='"+p.getLogin_id()+"')";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {

                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setScheme_catagory(rs.getString("Scheme_name"));
                prs.setAmount(rs.getString("Amount"));
                prs.setStatus(rs.getString("Status"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public PersonNameSetter getPersonName(String p) {
        PersonNameSetter pr = new PersonNameSetter();
        String sql = "select Person_name from Person where Person_id='"+p+"'";
        ResultSet rs = db.execQuery(sql);
        
        return pr;
    }

   
    public boolean AccountAlreadyExist(BankDataTacker p) {
        String sql = "select * from Bank where Account_no='" + p.getLblAccount_No()+ "' and Ifsc_code='" + p.getLblIFSC_Code()+ "'";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public void insertAccount(BankDataTacker p) {
     String sql = "insert into Bank values('"+p.getId()+"','"+p.getLblAccount_No()+"','"+p.getLblName()+"','"+p.getLblIFSC_Code()+"','"+p.getLblBank_Name()+"','"+p.getLblPlace()+"')";
     db.insert(sql);

     }

    public ArrayList<BankDataTacker> getPersonBank(String id) {
        ArrayList<BankDataTacker> pr = new ArrayList<>();
        String sql = "(select * from Bank where id='"+id+"')";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {

                BankDataTacker prs = new BankDataTacker();
                prs.setId(rs.getString("id"));
                prs.setLblAccount_No(rs.getString("Account_no"));
                prs.setLblName(rs.getString("name"));
                prs.setLblIFSC_Code(rs.getString("Ifsc_code"));
                prs.setLblBank_Name(rs.getString("Bank_name"));
                prs.setLblPlace(rs.getString("place"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

    public ArrayList<SchemeDataTaker> getPersonAccountDetails(String id) {
         ArrayList<SchemeDataTaker> pr = new ArrayList<>();
         String a="Accept";
        String sql = "(select * from Agree_Scheme where person_id='"+id+"' and Status='"+a+"')";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {

                SchemeDataTaker prs = new SchemeDataTaker();
                prs.setPerson_id(rs.getString("person_id"));
                prs.setScheme_catagory(rs.getString("Scheme_name"));
                prs.setAmount(rs.getString("Amount"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

   public ArrayList<PersonNameSetter> getPerson_id(PersonNameSetter prs) {
        ArrayList<PersonNameSetter> pr = new ArrayList<>();
        String sql = "select Person_id from Person where Person_name='" + prs.getName()+ "' and Ward_id='" + prs.getWard_no() + "' and House_no='"+prs.getHouse_no()+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {
                prs.setId(rs.getString("Person_id"));
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }
     public boolean isRelativeAlreadyExist(RelativeDataTacker p) {
        String sql = "select Relative_id,Name from Relative where Relative_id='" + p.getId()+ "' and Name='" + p.getLblName()+ "'";
        ResultSet rs = db.execQuery(sql);
        try {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void insertRelative(RelativeDataTacker p) {
        String sql="insert into Relative(Person_id,Name,Contact_no,Address,relation) values('"+p.getId()+"','"+p.getLblName()+"','"+p.getLblContact_No()+"','"+p.getLblAddress()+"','"+p.getLblRelation()+"')";
        db.insert(sql);
    }

   public ArrayList<PersonNameSetter> CollecteMyperInformation(PersonNameSetter p) {
        ArrayList<PersonNameSetter> pr = new ArrayList<>();
        String sql = "select login_id,Ward_id,House_no,Address,relation,Person_name,Person_image,Gender,Disability,DoB from Person where Person_id='"+ p.getId()+"'";
        ResultSet rs = db.execQuery(sql);
        try {

            while (rs.next()) {

                PersonNameSetter prs = new PersonNameSetter();
                prs.setDob(rs.getString("DoB"));
                prs.setWard_no(rs.getString("Ward_id"));
                prs.setHouse_no(rs.getString("House_no"));
                prs.setAddress(rs.getString("Address"));
                prs.setRelation(rs.getString("relation"));
                prs.setName(rs.getString("Person_name"));
                prs.setGender(rs.getString("Gender"));
                prs.setDisability(rs.getString("Disability"));
                prs.setPicture(rs.getBytes("Person_image"));
                ward=prs.getWard_no().toString();
                house=prs.getHouse_no().toString();
                address=prs.getAddress().toString();
                relation=prs.getRelation().toString();
                name=prs.getName().toString();
                gen=prs.getGender().toString();
                Dis=prs.getDisability().toString();
                Dof=prs.getDob().toString();
                byte[]im=rs.getBytes("Person_image");
               // ImageIcon image=new ImageIcon(prs.getPicture());
                new UserProfileFrame(ward,house,address,relation,name,gen,Dis,Dof,im);
                pr.add(prs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pr;
    }

   
    }
    
    
    
    

