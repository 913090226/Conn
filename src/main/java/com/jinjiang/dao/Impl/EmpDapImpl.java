package com.jinjiang.dao.Impl;

import com.jinjiang.dao.IEmpDao;
import com.jinjiang.domain.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry.zhang on 2016/11/24.
 */
public class EmpDapImpl implements IEmpDao {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public EmpDapImpl() {
    }

    public EmpDapImpl(Connection conn) {
        this.conn = conn;
    }

    public Employee findByEmpno(int empno) {
        try {
            String str = "select * from employee where empno = ?";
            PreparedStatement stm = conn.prepareStatement(str);
            stm.setInt(1, empno);
            ResultSet set = stm.executeQuery();
            if (set.next()) {
                return new Employee(set.getInt("empno"), set.getString("name"), set.getDate("hireday"), set.getDouble("salary"));
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<Employee>();
        try {
            String str = "select * from employee";
            PreparedStatement stm = conn.prepareStatement(str);
            ResultSet set = stm.executeQuery();
            while (set.next()) {
                employees.add(new Employee(set.getInt("empno"), set.getString("name"), set.getDate("hireday"), set.getDouble("salary")));
            }

        } catch (Exception e) {

        } finally {
            return employees;
        }
    }

    public int getCount() {
        try {
            String str = "select COUNT(1) as runcount from employee";
            PreparedStatement stm = conn.prepareStatement(str);
            ResultSet result = stm.executeQuery();
            if(result.next()){
                return(result.getInt("runcount"));
            }else{
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }
    }

    public boolean doCreate(Employee emp) {
        try{
            String str = "INSERT INTO employee (empno,name,hireday,salary)VALUES(?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(str);
            stm.setInt(1,emp.getEmpno());
            stm.setString(2,emp.getName());
            stm.setDate(3, new Date(emp.getHireday().getTime()));
            stm.setDouble(4,emp.getSalary());
            return stm.executeUpdate() == 1;
        }catch(Exception e){
            return false;
        }
    }

    public boolean doUpdate(Employee emp) {
        return false;
    }

    public boolean doDalete(List<Integer> empnoList) {
        return false;
    }
}
