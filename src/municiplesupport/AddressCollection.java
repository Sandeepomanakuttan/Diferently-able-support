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
public class AddressCollection {

    String wardNo, memberName, contactNo, houseNo, houseowner, address;


    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }


    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setHouseowner(String houseowner) {
        this.houseowner = houseowner;
    }

    /*public AddressCollection(String wardNo, String memberName, String contactNo, String houseNo, String houseowner, String address) {
    this.wardNo = wardNo;
    this.memberName = memberName;
    this.contactNo = contactNo;
    this.houseNo = houseNo;
    this.houseowner = houseowner;
    this.address = address;
    }*/
    public void setAddress(String address) {
        this.address = address;
    }

    public String getWardNo() {
        return wardNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getHouseowner() {
        return houseowner;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "AddressCollection{" + "wardNo=" + wardNo + ", memberName=" + memberName + ", contactNo=" + contactNo + ", houseNo=" + houseNo + ", houseowner=" + houseowner + ", address=" + address + '}';
    }
}