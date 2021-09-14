/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport.DataCollectionClass;

/**
 *
 * @author kishore
 */
public class HospitalDataTacker {
    String Disability,HospitalName,Disctrict,Place,About;

    public void setDisability(String Disability) {
        this.Disability = Disability;
    }

    public void setHospitalName(String HospitalName) {
        this.HospitalName = HospitalName;
    }

    public void setDisctrict(String Disctrict) {
        this.Disctrict = Disctrict;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public void setAbout(String About) {
        this.About = About;
    }

    @Override
    public String toString() {
        return "HospitalDataTacker{" + "Disability=" + Disability + ", HospitalName=" + HospitalName + ", Disctrict=" + Disctrict + ", Place=" + Place + ", About=" + About + '}';
    }

    public String getDisability() {
        return Disability;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public String getDisctrict() {
        return Disctrict;
    }

    public String getPlace() {
        return Place;
    }

    public String getAbout() {
        return About;
    }
    
    
}
