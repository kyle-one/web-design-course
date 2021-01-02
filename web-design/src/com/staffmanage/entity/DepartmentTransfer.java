package com.staffmanage.entity;


public class DepartmentTransfer {

  private String sid;
  private String did1;
  private String did2;
  private String tdate;
  private String reason;
  private String remarks;
  private String type;
  private int pf;

  public DepartmentTransfer(String sid, String did1, String did2, String tdate, String reason, String remarks, String type, int pf) {
    this.sid = sid;
    this.did1 = did1;
    this.did2 = did2;
    this.tdate = tdate;
    this.reason = reason;
    this.remarks = remarks;
    this.type = type;
    this.pf = pf;
  }

    public DepartmentTransfer() {

    }

    public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getDid1() {
    return did1;
  }

  public void setDid1(String did1) {
    this.did1 = did1;
  }


  public String getDid2() {
    return did2;
  }

  public void setDid2(String did2) {
    this.did2 = did2;
  }


  public String getTdate() {
    return tdate;
  }

  public void setTdate(String tdate) {
    this.tdate = tdate;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public int getPf() {
    return pf;
  }

  public void setPf(int pf) {
    this.pf = pf;
  }


}
