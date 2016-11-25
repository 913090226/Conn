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

    public EmpDapImpl() {
    }

    public EmpDapImpl(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
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
            if (result.next()) {
                return (result.getInt("runcount"));
            } else {
                return 0;
            }

        } catch (Exception e) {
            return 0;
        }
    }

    public boolean doCreate(Employee emp) {
        try {
            String str = "INSERT INTO employee (empno,name,hireday,salary)VALUES(?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(str);
            stm.setInt(1, emp.getEmpno());
            stm.setString(2, emp.getName());
            stm.setDate(3, new Date(emp.getHireday().getTime()));
            stm.setDouble(4, emp.getSalary());
            return stm.executeUpdate() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean doUpdate(Employee emp) {
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE employee SET empno = ?,name = ?,hireday = ?,salary = ? WHERE empno = ?");
            stm.setString(1, emp.getName());
            stm.setDate(2, new Date(emp.getHireday().getTime()));
            stm.setDouble(3, 500);
            stm.setInt(4, emp.getEmpno());
            return stm.executeUpdate() == 1;
        }catch(Exception e){
            return false;
        }
    }

    public boolean doDalete(List<Integer> empnoList) {
        try {
            StringBuffer sqlStr = new StringBuffer();
            for (Integer i : empnoList) {
                sqlStr.append("'"+i.toString()+"'");
                sqlStr.append(",");
            }
            if (empnoList.size() > 0) {
                sqlStr.delete(sqlStr.length() - 1, sqlStr.length());
                String str = "DELETE FROM employee WHERE empno in (" + sqlStr.toString() + ")";
                return conn.prepareStatement(str).executeUpdate()==empnoList.size();
            } else {
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
}
