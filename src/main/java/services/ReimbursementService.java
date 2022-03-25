package services;

import models.Reimbursement;
import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;

import java.util.List;

//todo finish ReimbursementService
public class ReimbursementService {
    //access repo
    private ReimbursementDAO reimbursementDAO;
    public ReimbursementService() {
        this.reimbursementDAO = new ReimbursementDAOImpl();
    }
    public ReimbursementService(ReimbursementDAO reimbursementDAO) {
        this.reimbursementDAO = reimbursementDAO;
    }

    public List<Reimbursement> getAllGivenUserId(Integer userId) {
        return this.reimbursementDAO.getAllReimbByUserId(userId);
    }

    public List<Reimbursement> getAllReimbursements(){
        return this.reimbursementDAO.getAllReimbursements();
    }

    public Reimbursement getOneReimb(int reimbId) {
        return this.reimbursementDAO.getOneReimbursement(reimbId);
    }

    public void createReimbursement(Reimbursement reimbursement) {
        this.reimbursementDAO.createReimbursement(reimbursement);
    }

    public void deleteReimb (int id) {
        this.reimbursementDAO.deleteReimbursement(id);
    }

    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the reimbursement request exists</li>
     *     <li>Must throw exception if the reimbursement request is not found</li>
     *     <li>Should persist the updated reimbursement status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     * <p>
     * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
     */

    public void processReimb (Integer statusId, Integer userId, Integer reimbId) {
        this.reimbursementDAO.proccessReimbursement(statusId, userId, reimbId);
    }

}

