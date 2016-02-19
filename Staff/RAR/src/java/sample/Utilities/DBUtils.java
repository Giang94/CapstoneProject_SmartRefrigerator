/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Dell
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        try {
            Context context = new InitialContext();
            Context tomcatCtx = (Context) context.lookup("java:comp/env");
            DataSource ds = (DataSource) tomcatCtx.lookup("DBCon");
            Connection con = ds.getConnection();
            return con;
        } catch (NamingException ex) {
            Logger.getLogger(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return null;
    }
}
