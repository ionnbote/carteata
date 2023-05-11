package services;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserProvider {

    private int getMaxUserId() {
        String sql = "SELECT MAX(UserId) AS id FROM user";
        MysqlConnect mysqlConnect = new MysqlConnect();
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idUser = rs.getInt("id");
                return idUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
        return 0;
    }

    public void addUser(User user) {
        int userId = getMaxUserId();
        userId++;
        user.setId(userId);

        String sql = "INSERT INTO user VALUES("
                + user.getId()
                + ", "
                + "'" + user.getLastName() + "'"
                + ", "
                + "'" + user.getFirstName() + "'"
                + ", "
                + "'" + user.getEmail() + "'"
                + ", "
                + "'" + user.getPassword() + "'"
                + ")";//(UserId,LastName,FirstName,Email,Parola)";
        MysqlConnect mysqlConnect = new MysqlConnect();
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
    }

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
