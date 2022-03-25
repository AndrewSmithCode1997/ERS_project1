package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimbursement;
import services.ReimbursementService;

import java.util.List;
import java.util.Objects;


public class ReimbursementController {
    ReimbursementService reimbursementService;

    public ReimbursementController() {
        this.reimbursementService = new ReimbursementService();
    }
    public ReimbursementController(ReimbursementService reimbursementService){
        this.reimbursementService = reimbursementService;
    }

    public void displayAllReimbForUser(Context context) {
        Integer userId = Integer.parseInt(context.queryParam("userId"));

        List<Reimbursement> reimb = reimbursementService.getAllGivenUserId(userId);
        context.json(new JsonResponse(true, "listing all Reimbursements for user" + userId, reimb));
    }

    public void createReimb(Context context) {
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);

        reimbursementService.createReimbursement(reimbursement);
        context.json(new JsonResponse(true, "list created for user " + reimbursement.getAuthor_fk(), null));
    }

    public void deleteReimbursement(Context context) {
        //NOTE: "reimbursementId" has to match the path parameter in MainDriver ie: /reimbursement/{reimbursementId}
        Integer reimbId = Integer.parseInt(context.pathParam("reimbursementId"));

        reimbursementService.deleteReimb(reimbId);
        context.json(new JsonResponse(true, "Reimbursement deleted if exist", null));
    }

    public void processReimbursement(Context context) {
        Integer userId = Integer.parseInt(context.pathParam("userId"));
        Integer statusId = Integer.parseInt(context.queryParam("statusId"));
        Integer reimbId = Integer.parseInt(context.queryParam("reimbId"));

        reimbursementService.processReimb(statusId, userId, reimbId);
        context.json(new JsonResponse(true, "Reimbursement has been processed" + userId, null));
    }

    public void displayAllReimbursements (Context context) {
        //todo create function to get all reimbursements
        List<Reimbursement> allReimb = reimbursementService.getAllReimbursements();
        context.json(new JsonResponse(true, "listing all Reimbursements", allReimb));
    }
}
