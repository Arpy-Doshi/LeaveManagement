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
    public void createTest()  {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Yash");
        employee.setDepartment("Java");

        try {
            boolean status = employeeDao.create(employee);
            Assert.assertEquals(true, status);
        }
        catch(IOException e){
         e.printStackTrace();
        }
    }

    @Test
    public void getAllTest() {

        Employee employee = new Employee();
        employee.setId("3");
        employee.setName("dffbf");
        employee.setDepartment("ndfhfjd");


        try {
           boolean status = employeeDao.create(employee);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Employee>  employees = employeeDao.getAll();
            Assert.assertNotNull(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByIdTest()  {

        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("Arpy");

        employee.setDepartment("Java");


        try {
            boolean  status = employeeDao.create(employee);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            Employee  employee1 = employeeDao.getById("2");
            Assert.assertNotNull(employee1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void update() {

        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("pr");

        employee.setDepartment("Java");


        try {
            boolean status = employeeDao.create(employee);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Employee employee1 = new Employee();
        employee1.setName("arpy");

        try {
            boolean status1 = employeeDao.update(employee1,"2");
            Assert.assertEquals(true,status1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete()  {
        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("Arpy");
        employee.setDepartment("Java");


        try {
            boolean status = employeeDao.create(employee);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            boolean  status1 = employeeDao.delete("2");
            Assert.assertEquals(true,status1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
