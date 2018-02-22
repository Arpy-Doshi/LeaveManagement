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

        Employee employee = new Employee();
        employee.setId("3");
        employee.setName("dffbf");
        employee.setDepartment("ndfhfjd");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        List<Employee> employees = employeeDao.getAll();
        int size = employees.size();
        Assert.assertEquals(3,size);
    }

    @Test
    public void get() throws IOException {

        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("Arpy");

        employee.setDepartment("Java");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        Employee employee1 = employeeDao.getById("2");
        Assert.assertNotNull(employee1);
    }

    @Test
    public void update() throws IOException {

        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("pr");

        employee.setDepartment("Java");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        Employee employee1 = new Employee();
        employee.setName("arpy");
        boolean status1 = employeeDao.update(employee,"2");
        Assert.assertEquals(true,status);
    }

    @Test
    public void delete() throws IOException {
        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("Arpy");
        employee.setDepartment("Java");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        boolean status1=employeeDao.delete("2");
        Assert.assertEquals(true,status1);
    }
}
