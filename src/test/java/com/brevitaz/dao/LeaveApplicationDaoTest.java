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
        leaveApplication.setReason("xyz");

        leaveApplicationDao.request(leaveApplication,leaveApplication.getEmp_id());


        LeaveApplication leaveApplication1 = new LeaveApplication();
        leaveApplication1.setReason("pqr");

        boolean status1 = leaveApplicationDao.updateRequest(leaveApplication1,"AA","1");
        Assert.assertEquals(true,status1);
    }


    @Test
    public void getAllTest() throws IOException {

        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("xyz");

        boolean status = leaveApplicationDao.request(leaveApplication,leaveApplication.getEmp_id());
        Assert.assertEquals(true,status);


        List<LeaveApplication> leaveApplicatios = leaveApplicationDao.getAll();
        Assert.assertNotNull(leaveApplicatios);
       /* int size = leaveApplicatios.size();
        Assert.assertEquals(2,size);*/
    }

    @Test
    public void checkStatus() throws IOException
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("xyz");

        boolean status = leaveApplicationDao.request(leaveApplication,leaveApplication.getEmp_id());
        Assert.assertEquals(true,status);

        LeaveApplication leaveApplication1 = leaveApplicationDao.checkStatus("AA","1");
        Assert.assertNotNull(leaveApplication1);
    }

    @Test
    public void getByIDTest()throws IOException
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("xyz");

        boolean status = leaveApplicationDao.request(leaveApplication,"AA");
        Assert.assertEquals(true,status);

         List<LeaveApplication>leaveApplications = leaveApplicationDao.getById("AA");
        Assert.assertNotNull(leaveApplications);
    }

    @Test
    public void checkrRequestTest() throws IOException
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("xyz");
        //leaveApplication.setStatus();

        boolean status = leaveApplicationDao.request(leaveApplication,leaveApplication.getEmp_id());
        Assert.assertEquals(true,status);

        LeaveApplication leaveApplication1 = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmp_id("AA");
        leaveApplication.setReason("xyz");

        boolean status1 = leaveApplicationDao.request(leaveApplication,leaveApplication.getEmp_id());
        Assert.assertEquals(true,status1);
    }
}
