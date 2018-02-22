package com.brevitaz.dao;

import com.brevitaz.dao.EmployeeDao;
import com.brevitaz.dao.impl.EmployeeDaoImpl;
import com.brevitaz.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.io.IOException;
import java.util.List;

public class EmployeeDaoTest
{
    @InjectMocks
    EmployeeDaoImpl employeeDaoImpl;


    @Before
    public void init()
    {
        employeeDaoImpl = new EmployeeDaoImpl();
    }


    @Test
    public boolean create(Employee employee)
    {
        return true;
    }


}
