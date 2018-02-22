package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void createTest() throws IOException {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Yash");

        employee.setDepartment("Java");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        List<Employee> employees = employeeDao.getAll();
        int size = employees.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void get() throws IOException {
        Employee employee = employeeDao.getById("1");
        Assert.assertNotNull(employee);
    }

    @Test
    public void update() throws IOException {
        Employee employee = new Employee();
        employee.setName("arpy");
        boolean status = employeeDao.update(employee,"1");
        Assert.assertEquals(true,status);
    }

    @Test
    public void delete() throws IOException {
        boolean status=employeeDao.delete("1");
        Assert.assertEquals(true,status);
    }
}
