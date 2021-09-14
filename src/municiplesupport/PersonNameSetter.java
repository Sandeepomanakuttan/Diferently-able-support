/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

/**
 *
 * @author kishore
 */
public class PersonNameSetter {
    private String id,ward_no, house_no, address, relation, name, gender, disability, username1, pass,Dob;
    byte[] picture,idpicture,medicalpicture;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public byte[] getIdpicture() {
        return idpicture;
    }

    public void setIdpicture(byte[] idpicture) {
        this.idpicture = idpicture;
    }

    public void setMedicalpicture(byte[] medicalpicture) {
        this.medicalpicture = medicalpicture;
    }

    public byte[] getMedicalpicture() {
        return medicalpicture;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public void setWard_no(String ward_no) {
        this.ward_no = ward_no;
    }

 
    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getDob() {
        return Dob;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "PersonNameSetter{" + "id=" + id + ", ward_no=" + ward_no + ", house_no=" + house_no + ", address=" + address + ", relation=" + relation + ", name=" + name + ", gender=" + gender + ", disability=" + disability + ", username1=" + username1 + ", pass=" + pass + ", Dob=" + Dob + ", medicalpicture=" + medicalpicture + '}';
    }

   

   


    

   
   

    public String getWard_no() {
        return ward_no;
    }

    public String getHouse_no() {
        return house_no;
    }

    public String getAddress() {
        return address;
    }

    public String getRelation() {
        return relation;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDisability() {
        return disability;
    }

    public String getUsername1() {
        return username1;
    }

    public String getPass() {
        return pass;
    }
    
    
}