package com.jinjiang.domain;

import java.util.Date;

/**
 * Created by jerry.zhang on 2016/11/24.
 */
public class Employee {
    private int empno;
    private String name;
    private Date hireday;
    private double salary;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireday() {
        return hireday;
    }

    public void setHireday(Date hireday) {
        this.hireday = hireday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(int empno, String name, Date hireday, double salary) {
        this.empno = empno;
        this.name = name;
        this.hireday = hireday;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", hireday=" + hireday +
                ", salary=" + salary +
                '}';
    }
}
