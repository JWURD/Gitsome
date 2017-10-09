package com.revature.model;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Creating the requirements for reimbursement.
 * 
 * @author josh wurdemann
 * @version 9/2/2017
 */
public class Reimbursement {
  private int reimburseId; // (PK)
  private int submitterID;// (FK, not null)
  private int resolverID; // (FK)
  private Timestamp submitDate; // java sql(not null) (TimeStamp)
  private Timestamp resolvedDate; // java sql(not null) (TimeStamp)
  private int statusID;// StatusID (FK, Default = 0)
  private String description; // (VarChar2)
  private String resolvedNote; // should be less than 500characters (VarChar2)
  private double amount; // (not null) (NUMBER(11,2)) (>1)

  public Reimbursement(int reimburseId, int submitterID, int resolverID, Timestamp submitDate,
      Timestamp resolvedDate, int statusID, String description, String resolvedNote,
      double amount) {

    super();
    this.reimburseId = reimburseId;
    this.submitterID = submitterID;
    this.resolverID = resolverID;
    this.submitDate = submitDate;
    this.resolvedDate = resolvedDate;
    this.statusID = statusID;
    this.description = description;
    this.resolvedNote = resolvedNote;
    this.amount = amount;
  }

  public Reimbursement() {

  }

  @Override
  public String toString() {
    return "Reimbursement [rId=" + reimburseId + ", submitterID=" + submitterID + ", resolverID="
        + resolverID + ", submitDate=" + submitDate + ", resolvedDate=" + resolvedDate
        + ", description=" + description + ", resolvedNote=" + resolvedNote + ", amount=" + amount
        + "]";
  }

  public int getReimburseid() {
    return reimburseId;
  }

  public void setReimburseId(int reimburseId) {
    this.reimburseId = reimburseId;
  }

  public int getSubmitterID() {
    return submitterID;
  }

  public void setSubmitterID(int submitterID) {
    this.submitterID = submitterID;
  }

  public int getResolverID() {
    return resolverID;
  }

  public void setResolverID(int resolverID) {
    this.resolverID = resolverID;
  }

  public Timestamp getSubmitDate() {
    submitDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    
    return submitDate;
  }

  public void setSubmitDate(Timestamp submitDate) {
    this.submitDate = submitDate;
  }

  public Timestamp getResolvedDate() {
    return resolvedDate;
  }

  public void setResolvedDate(Timestamp resolvedDate) {
    this.resolvedDate = resolvedDate;
  }

  public int getStatusID() {
    return statusID;
  }

  public void setStatusID(int statusID) {
    this.statusID = statusID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getResolvedNote() {
    return resolvedNote;
  }

  public void setResolvedNote(String resolvedNote) {
    this.resolvedNote = resolvedNote;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

}
