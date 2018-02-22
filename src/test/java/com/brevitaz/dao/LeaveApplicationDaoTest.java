package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import com.brevitaz.model.LeaveApplication;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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
public class LeaveApplicationDaoTest {

    @Autowired
    LeaveApplicationDao leaveApplicationDao;

    @Test
    public void requestTest() throws IOException {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("xyz");

        boolean status = leaveApplicationDao.request(leaveApplication,leaveApplication.getEmp_id());
        Assert.assertEquals(true,status);
    }

    @Test
    public void cancelRequestTest() throws IOException
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("BB");

        leaveApplication.setReason("xyz");

        boolean status = leaveApplicationDao.cancelRequest("BB","1");
        Assert.assertEquals(true,status);
    }

    @Test
    public void updateRequestTest() throws IOException
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("pqr");

        boolean status = leaveApplicationDao.updateRequest(leaveApplication,"AA","1");
        Assert.assertEquals(true,status);
    }


    @Test
    public void getAllTest() throws IOException {
        List<LeaveApplication> leaveApplicatios = leaveApplicationDao.getAll();
        int size = leaveApplicatios.size();
        Assert.assertEquals(2,size);
    }

   /* @Test
    public void get() throws IOException {
        Employee employee = employeeDao.getById("1");
        Assert.assertNotNull(employee);
    }*/

  /*  @Test
    public void update() throws IOException {
        Employee employee = new Employee();
        employee.setName("arpy");
        boolean status = employeeDao.update(employee,"1");
        Assert.assertEquals(true,status);
    }
*/
    /*@Test
    public void delete() throws IOException {
        boolean status = employeeDao.delete("1");
        Assert.assertEquals(true, status);
    }*/
}
