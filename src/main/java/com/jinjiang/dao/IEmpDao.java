package com.jinjiang.dao;

import com.jinjiang.domain.Employee;
import java.util.List;

/**
 * Created by jerry.zhang on 2016/11/24.
 */
public interface IEmpDao  {
    /**
     *
     * @param empno
     * @return
     */
    public Employee findByEmpno(int empno);

    public List<Employee> findAll();

    public int getCount();

    public boolean doCreate(Employee emp);

    public boolean doUpdate(Employee emp);

    public boolean doDalete(List<Integer> empnoList);


}
