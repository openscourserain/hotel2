package com.seecen.sc1709.hotel.entity;

import oracle.sql.DATE;

import java.util.Date;

public class CCEmp {
    private int empno; //员工编号
    private double comm;//奖金
    private String ename;//员工姓名
    private Date hiredate;//员工入职日期
    private String job;//工种
    private double sal;//月薪

    public CCEmp() {
    }

    public CCEmp(int empno, double comm, String ename, Date hiredate, String job, double sal) {
        this.empno = empno;
        this.comm = comm;
        this.ename = ename;
        this.hiredate = hiredate;
        this.job = job;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "CCEmp{" +
                "empno=" + empno +
                ", comm=" + comm +
                ", ename='" + ename + '\'' +
                ", hiredate=" + hiredate +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
