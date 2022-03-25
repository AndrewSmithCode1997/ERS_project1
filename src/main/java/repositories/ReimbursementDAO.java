package repositories;

import models.Reimbursement;
import models.User;

import java.util.List;

public interface ReimbursementDAO {
    Reimbursement getOneReimbursement (int id);
    Boolean createReimbursement (Reimbursement reimbursement);
    void proccessReimbursement (Integer statusId, Integer userId, Integer reimbId);
    void deleteReimbursement (int id);
    List<Reimbursement> getAllReimbByUserId (Integer userId);
    List<Reimbursement> getAllReimbursements();
}
