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
public class SetUserNamePasswordData {

    String Username, Password,login_id;

    @Override
    public String toString() {
        return "SetUserNamePasswordData{" + "login_id=" + login_id + '}';
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getLogin_id() {
        return login_id;
    }

    public SetUserNamePasswordData(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

}
