package models;

import java.sql.Date;
import java.util.Objects;
/*
* Bare minimum for the Reimbursement system to function
*
* */

public class AbstractReimbursement {
    private Integer Id;
    private Double amount;
    private Date submitted;
    private Date resolved;
    private String description;
    private int author_fk;
    private int resolver_fk;
    private int status_fk;
    private int type_fk;

    /* todo variables to add later for more functionality and quality of life */
    // picture of reciept


    public AbstractReimbursement() {
    }

    public AbstractReimbursement(String description, int author_fk) {
        this.description = description;
        this.author_fk = author_fk;
    }

    public AbstractReimbursement(Integer id, Double amount, Date submitted, Date resolved, String description, int author, int status, int type) {}

    //constructor for new Reimbursement
    public AbstractReimbursement(Double amount, String description, int author_fk, int status_fk, int type_fk) {
        this.amount = amount;
        this.description = description;
        this.author_fk = author_fk;
        this.status_fk = status_fk;
        this.type_fk = type_fk;
    }

    //constructor for retrieving a list of reimbursements where the value is not-null
    public AbstractReimbursement(Integer Id, Double amount, Date submitted, int author_fk, int status_fk, int type_fk) {
        this.Id = Id;
        this.amount = amount;
        this.submitted = submitted;
        this.author_fk = author_fk;
        this.status_fk = status_fk;
        this.type_fk = type_fk;
    }


    public AbstractReimbursement(Integer id, Double amount, Date submitted, Date resolved, String description, int author_fk, int resolver_fk, int status_fk, int type_fk) {
        Id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.author_fk = author_fk;
        this.resolver_fk = resolver_fk;
        this.status_fk = status_fk;
        this.type_fk = type_fk;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor_fk() {
        return author_fk;
    }

    public void setAuthor_fk(int author_fk) {
        this.author_fk = author_fk;
    }

    public int getResolver_fk() {
        return resolver_fk;
    }

    public void setResolver_fk(int resolver_fk) {
        this.resolver_fk = resolver_fk;
    }

    public int getStatus_fk() {
        return status_fk;
    }

    public void setStatus_fk(int status_fk) {
        this.status_fk = status_fk;
    }

    public int getType_fk() {
        return type_fk;
    }

    public void setType_fk(int type_fk) {
        this.type_fk = type_fk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractReimbursement)) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return Id == that.Id && author_fk == that.author_fk && resolver_fk == that.resolver_fk && status_fk == that.status_fk && type_fk == that.type_fk && amount.equals(that.amount) && submitted.equals(that.submitted) && Objects.equals(resolved, that.resolved) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, amount, submitted, resolved, description, author_fk, resolver_fk, status_fk, type_fk);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "Id=" + Id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", author_fk=" + author_fk +
                ", resolver_fk=" + resolver_fk +
                ", status_fk=" + status_fk +
                ", type_fk=" + type_fk +
                '}';
    }
}
