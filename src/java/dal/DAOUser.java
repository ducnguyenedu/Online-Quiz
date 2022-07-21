/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author duchi
 */
public class DAOUser extends DBContext {

    private User user;
    private boolean login;

    public boolean login(String username, String password) {
        login = false;
        try {
            String sql = "SELECT u.[name] as uname\n"
                    + "      ,u.[pass] as upass\n"
                    + "      ,u.[type] as utype\n"
                    + "      ,ISNULL(u.[email],'') as uemail\n"
                    + "  FROM [dbo].[User] u\n"
                    + "  WHERE u.[name] = ? AND u.[pass] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                login = true;
                user = new User();
                user.setName(rs.getString("uname"));
                user.setPass(rs.getString("upass"));
                user.setType(rs.getInt("utype"));
                user.setEmail(rs.getString("uemail"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return login;

    }

    public boolean register(String username, String password, int type, String email) {
        boolean register = false;
        try {
            String sql = "DECLARE @isApper int =0\n"
                    + "DECLARE @uname varchar(150) = ?\n"
                    + "DECLARE @upass varchar(150) = ?\n"
                    + "DECLARE @utype int = ?\n"
                    + "DECLARE @uemail varchar(150) = ?\n"
                    + "SELECT COUNT(u.[name]) as isApper\n"
                    + " FROM [dbo].[User] u\n"
                    + "  WHERE u.[name] = @uname\n"
                    + "\n"
                    + "set @isApper = ( SELECT COUNT(u.[name]) as isApper\n"
                    + "	   FROM [dbo].[User] u\n"
                    + "  WHERE u.[name] = @uname)\n"
                    + "\n"
                    + "  if(@isApper =0 )\n"
                    + "  Begin\n"
                    + "  INSERT INTO [dbo].[User]\n"
                    + "           ([name]\n"
                    + "           ,[pass]\n"
                    + "           ,[type]\n"
                    + "           ,[email])\n"
                    + "     VALUES\n"
                    + "           (@uname\n"
                    + "           ,@upass\n"
                    + "           ,@utype\n"
                    + "           ,@uemail)\n"
                    + "  End";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, username);
            stm.setString(2, password);
            stm.setInt(3, type);

            stm.setString(4, email);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
               register = rs.getInt("isApper")==0;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return register;

    }

    public User getUser() {

        return user;

    }

}
