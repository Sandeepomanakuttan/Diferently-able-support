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
public class GetloginData {
    String user_Name,Password;

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "GetloginData{" + "user_Name=" + user_Name + ", Password=" + Password + '}';
    }

    public String getUser_Name() {
        return user_Name;
    }

    public String getPassword() {
        return Password;
    }
    
}
