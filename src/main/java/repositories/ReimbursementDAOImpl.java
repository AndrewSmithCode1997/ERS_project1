package repositories;

import models.Reimbursement;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{

    @Override
    public List<Reimbursement> getAllReimbByUserId(Integer userId) {
        List<Reimbursement> reimbList = new ArrayList<>(); //creates a list of reimbursement tickets

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author_fk = ? ORDER BY reimb_id;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbList.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getDouble(2),
                                rs.getDate(3),
                                rs.getDate(4),
                                rs.getString(5),
                                rs.getInt(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9)
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return reimbList;
    }



    @Override
    public Reimbursement getOneReimbursement(int reimbId) {
        Reimbursement reimbursement = null;

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //todo needs to get all of the data for the Reimbursement object
                reimbursement = new Reimbursement(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9));
            } //end of while loop

        }catch (SQLException e){
            e.printStackTrace();
        }

        return reimbursement; //returns one reimbursement object
    }

    @Override
    public Boolean createReimbursement(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author_fk, reimb_status_fk, reimb_type_fk)" +
                    "VALUES (?, ?, ?, ?, ?);";
            //gets the Reimbursement object and inserts the values into the database
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, reimbursement.getAmount());
            ps.setString(2, reimbursement.getDescription());
            ps.setInt(3, reimbursement.getAuthor_fk());
            ps.setInt(4, reimbursement.getStatus_fk());
            ps.setInt(5, reimbursement.getType_fk());

            return ps.executeUpdate() != 0; //returns true if the update in sql worked

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void deleteReimbursement(int reimbId) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbId);

            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void proccessReimbursement(Integer statusId, Integer userId, Integer reimbId) {

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update ers_reimbursement set reimb_resolver_fk = ?, reimb_status_fk = ?, reimb_resolved = now() where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, statusId);
            ps.setInt(3, reimbId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reimbursement> getAllReimbursements() {
        List<Reimbursement> reimbursements = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ers_reimbursement";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)
                ));}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }
}
