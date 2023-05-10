package services;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserProvider {
    public User getUser(String email, String password) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sql = "SELECT * FROM user where Email = '" + email + "' and Parola = '" + password + "'";
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idUser = rs.getInt("UserId");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String mail = rs.getString("email");
                String passw = rs.getString("parola");
                User user = new User();
                user.setId(idUser);
                user.setLastName(lastName);
                user.setFirstName(firstName);
                user.setEmail(mail);
                user.setPassword(passw);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}
