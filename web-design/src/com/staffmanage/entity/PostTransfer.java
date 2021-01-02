package com.staffmanage.entity;


public class PostTransfer {

  private String sid;
  private String pid1;
  private String tdate;
  private String pid2;
  private String reason;
  private String remarks;
  private String type;
  private int pf;

  public PostTransfer() {
  }

  public PostTransfer(String sid, String pid1, String pid2, String tdate, String reason, String remarks, String type, int pf) {
    this.sid = sid;
    this.pid1 = pid1;
    this.tdate = tdate;
    this.pid2 = pid2;
    this.reason = reason;
    this.remarks = remarks;
    this.type = type;
    this.pf = pf;
  }

  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getPid1() {
    return pid1;
  }

  public void setPid1(String pid1) {
    this.pid1 = pid1;
  }


  public String getTdate() {
    return tdate;
  }

  public void setTdate(String tdate) {
    this.tdate = tdate;
  }


  public String getPid2() {
    return pid2;
  }

  public void setPid2(String pid2) {
    this.pid2 = pid2;
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
    return type;
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
