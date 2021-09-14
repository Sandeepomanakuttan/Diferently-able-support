/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

/**
 *
 * @author RAMESH
 */
public class RelativeDataTacker {
    
    String lblRelation,lblName,lblAddress,lblContact_No,id;

    public void setLblRelation(String lblRelation) {
        this.lblRelation = lblRelation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLblName(String lblName) {
        this.lblName = lblName;
    }

   

    public String getLblRelation() {
        return lblRelation;
    }

    @Override
    public String toString() {
        return "RelativeDataTacker{" + "lblRelation=" + lblRelation + ", lblName=" + lblName + ", lblAddress=" + lblAddress + ", lblContact_No=" + lblContact_No + ", id=" + id + '}';
    }

    public String getLblName() {
        return lblName;
    }

    public String getLblAddress() {
        return lblAddress;
    }

    public String getLblContact_No() {
        return lblContact_No;
    }

    public void setLblAddress(String lblAddress) {
        this.lblAddress = lblAddress;
    }

    public void setLblContact_No(String lblContact_No) {
        this.lblContact_No = lblContact_No;
    }
    
    
}
