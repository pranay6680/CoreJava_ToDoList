package com.example.demo.model;

public class ToDoModel {
    final String start = "START";
    final String stat = "\t Status :";
    final String crtd = " Created at : ";
    final String updt = " Updated at : ";
    final String inProg = "IN PROGRESSS";
    final String dn = "DONE";
    private int ins;
    private String ss;

    public String getDn() {
        return dn;
    }

    public String getInProg() {
        return inProg;
    }

    public String getCrtd() {
        return crtd;
    }

    public String getStat() {
        return stat;
    }

    public String getStart() {
        return start;
    }
    public int getIns() {
        return ins;
    }

    public void setIns(int ins) {
        this.ins = ins;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getUpdt() {
        return updt;
    }
}
