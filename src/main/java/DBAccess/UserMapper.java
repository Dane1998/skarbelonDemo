package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void changePassword (String password, String email) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE users SET password = ? WHERE email = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,password);
            ps.setString(2,email);
            ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException ex){
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static void deleteUser(String email) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM users WHERE email = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,email);
            ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException ex){
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static List<User> getAllUsers() throws LoginSampleException {
       List<User> userList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM users";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                User user = new User(email, password, role);
                userList.add(user);
            }
            } catch(ClassNotFoundException | SQLException ex){
                throw new LoginSampleException(ex.getMessage());
            }
            return userList;
        }


    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
