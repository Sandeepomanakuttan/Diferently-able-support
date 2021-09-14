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
public class SchemeDataTaker {
    String Disability,Scheme_catagory,Scheme_criteria,person_id,Amount,Status,Total,Date,Month,Year;

    public String getDate() {
        return Date;
    }

    public String getMonth() {
        return Month;
    }

    public String getYear() {
        return Year;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAmount() {
        return Amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setDisability(String Disability) {
        this.Disability = Disability;
    }

    public void setScheme_catagory(String Scheme_catagory) {
        this.Scheme_catagory = Scheme_catagory;
    }

    public void setScheme_criteria(String Scheme_criteria) {
        this.Scheme_criteria = Scheme_criteria;
    }

    public String getPerson_id() {
        return person_id;
    }

    @Override
    public String toString() {
        return "SchemeDataTaker{" + "Disability=" + Disability + ", Scheme_catagory=" + Scheme_catagory + ", Scheme_criteria=" + Scheme_criteria + ", person_id=" + person_id + ", Amount=" + Amount + ", Status=" + Status + ", Total=" + Total + ", Date=" + Date + ", Month=" + Month + ", Year=" + Year + '}';
    }

   

   

    public String getDisability() {
        return Disability;
    }

    public String getScheme_catagory() {
        return Scheme_catagory;
    }

    public String getScheme_criteria() {
        return Scheme_criteria;
    }

   
    
    
}
