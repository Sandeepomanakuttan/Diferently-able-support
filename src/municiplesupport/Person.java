/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

/**
 *
 * @author s4ct
 */
public class Person {

    String ward_no, house_no, address, relation, name, gender, disability, username1, pass;

    public Person(String ward_no, String house_no, String address, String relation, String name, String gender, String disability, String username1, String pass) {
        this.ward_no = ward_no;
        this.house_no = house_no;
        this.address = address;
        this.relation = relation;
        this.name = name;
        this.gender = gender;
        this.disability = disability;
        this.username1 = username1;
        this.pass = pass;
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
