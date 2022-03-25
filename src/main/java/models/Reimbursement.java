package models;

import java.sql.Date;

public class Reimbursement extends AbstractReimbursement{

    public Reimbursement() {
        super();
    }

    public Reimbursement(int id, Double amount, Date submitted, int author_fk, int status_fk, int type_fk) {
        super(id, amount, submitted, author_fk, status_fk, type_fk);
    }

    public Reimbursement(int id, Double amount, Date submitted, Date resolved, String description, int author, int status, int type) {
        super(id, amount, submitted, resolved, description, author, status, type);
    }

    public Reimbursement(int id, Double amount, Date submitted, Date resolved, String description, int author_fk, int resolver_fk, int status_fk, int type_fk) {
        super(id, amount, submitted, resolved, description, author_fk, resolver_fk, status_fk, type_fk);
    }



}
