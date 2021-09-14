/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport;

import java.sql.ResultSet;

/**
 *
 * @author s4ct
 */
public class loginData {

    String name, pass,login_id;

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "loginData{" + "name=" + name + ", pass=" + pass + ", login_id=" + login_id + '}';
    }

 

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    
}
