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
    public void createTest() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        Employee employee1 = employeeDao.getById("11");
        Assert.assertEquals(employee1.getName(), employee.getName());
        employeeDao.delete("11");
    }

    @Test
    public void getAllTest() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Employee> employees = employeeDao.getAll();
        int size = employees.size();

        Assert.assertEquals(1,size);
        employeeDao.delete("11");

    }

    @Test
    public void getByIdTest() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        Employee employee1 = employeeDao.getById("11");
        Assert.assertEquals(employee1.getName(),employee.getName());
        employeeDao.delete("11");
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        Employee employee1 = new Employee();
        employee1.setName("Arpy");
        employeeDao.update(employee1,"11");

        Employee employee3 = employeeDao.getById("11");
        Assert.assertEquals(employee3.getName(),employee1.getName());
        employeeDao.delete("11");
    }

    @Test
    public void delete() {
        Employee employee = new Employee();
        employee.setId("11");
        employee.setName("Yash");
        employee.setDepartment("Java");
        employeeDao.create(employee);

        employeeDao.delete("11");
        Employee employee1 = employeeDao.getById("11");

        Assert.assertNull(employee1);
    }
}
