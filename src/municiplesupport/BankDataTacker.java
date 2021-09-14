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
public class BankDataTacker {
    String lblAccount_No,lblRe_Enter_Account_No,lblName,lblIFSC_Code,lblBank_Name,lblPlace,id;

    public String getLblAccount_No() {
        return lblAccount_No;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLblRe_Enter_Account_No() {
        return lblRe_Enter_Account_No;
    }

   

    public String getLblName() {
        return lblName;
    }

    @Override
    public String toString() {
        return "BankDataTacker{" + "lblAccount_No=" + lblAccount_No + ", lblRe_Enter_Account_No=" + lblRe_Enter_Account_No + ", lblName=" + lblName + ", lblIFSC_Code=" + lblIFSC_Code + ", lblBank_Name=" + lblBank_Name + ", lblPlace=" + lblPlace + ", id=" + id + '}';
    }

    public void setLblAccount_No(String lblAccount_No) {
        this.lblAccount_No = lblAccount_No;
    }

    public void setLblRe_Enter_Account_No(String lblRe_Enter_Account_No) {
        this.lblRe_Enter_Account_No = lblRe_Enter_Account_No;
    }

    public void setLblName(String lblName) {
        this.lblName = lblName;
    }

    public void setLblIFSC_Code(String lblIFSC_Code) {
        this.lblIFSC_Code = lblIFSC_Code;
    }

    public void setLblBank_Name(String lblBank_Name) {
        this.lblBank_Name = lblBank_Name;
    }

    public void setLblPlace(String lblPlace) {
        this.lblPlace = lblPlace;
    }

    public String getLblIFSC_Code() {
        return lblIFSC_Code;
    }

    public String getLblBank_Name() {
        return lblBank_Name;
    }

    public String getLblPlace() {
        return lblPlace;
    }
    
}
