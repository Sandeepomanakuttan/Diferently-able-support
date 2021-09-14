/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municiplesupport.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import municiplesupport.Database.Database;

/**
 *
 * @author kishore
 */
public class LoginController {
     private Database db;

    public LoginController() {
        db = new Database();
    }
    
    public String getUserType(String uname,String pswd){
    
     String sql = "select * from login where username='" + uname+"' and password='"+pswd+"' and isverified=TRUE";
        ResultSet rs = db.execQuery(sql);
        try {
            if (rs.next()) {
                return rs.getString("user_type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

