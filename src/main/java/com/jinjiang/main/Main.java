package com.jinjiang.main;
import com.jinjiang.dao.Impl.EmpDapImpl;
import com.jinjiang.database.DatabaseConnection;
import com.jinjiang.domain.Employee;
import org.gjt.mm.mysql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by jerry.zhang on 2016/11/24.
 */
public class Main {
   public static void main(String [] args){
      /* Connection conn = null;
       System.out.println("hello world");
       try {
           //Class.forName("com.mysql.jdbc.Driver");
           //conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring4_mybatis3?characterEncoding=utf8&useSSL=true", "root", "Jj123456");
           conn = new DatabaseConnection().getConn();
           String sqlStr = "SELECT * FROM employee";
           PreparedStatement stm = conn.prepareStatement(sqlStr);
           ResultSet resultSet = stm.executeQuery();
           List<Employee> employees = new ArrayList<Employee>();
           while(resultSet.next()){
               employees.add(new Employee(resultSet.getInt("empno"),resultSet.getString("name"),resultSet.getDate("hireday"),resultSet.getDouble("salary")));
           }
           System.out.println(employees);
           conn.close();
       }
       catch(Exception e){
       }
       finally{

       }*/

       try {
           EmpDapImpl empDapImpl = new EmpDapImpl(new DatabaseConnection().getConn());
           System.out.println(empDapImpl.findByEmpno(2));
           System.out.println(empDapImpl.findAll());
           System.out.println(empDapImpl.getCount());

           System.out.println(empDapImpl.doCreate(new Employee(5,"test5",new GregorianCalendar().getTime(),56.0D)));
           new DatabaseConnection().closeConn();
       }
       catch(Exception e)
       {
           System.out.print(e.getMessage());
       }
   }
}
