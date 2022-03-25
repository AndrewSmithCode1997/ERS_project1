package repositories;

import models.Role;
import models.User;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public User getByUsername(String username) {
        User user = null;
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /*
    * Method for creating the user object and inserting the user data into the database
    *
    * @params: user
    * @return: void
    * */
    @Override
    public void createUser(User user) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_fk) VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getUserEmail());
            //todo find a way to dynamically get the user_role_fk and get it in json
            ps.setInt(6, user.getRoleId());

            ps.executeUpdate();

        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
}
