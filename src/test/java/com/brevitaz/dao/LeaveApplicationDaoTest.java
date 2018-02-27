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
    public void requestTest()  {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");

        try {
            boolean status = leaveApplicationDao.request(leaveApplication);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cancelRequestTest()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("BB");

        leaveApplication.setReason("xyz");

        try {
            boolean status = leaveApplicationDao.cancelRequest("1");
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateRequestTest()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");

        try {
            leaveApplicationDao.request(leaveApplication);
        } catch (IOException e) {
            e.printStackTrace();
        }


        LeaveApplication leaveApplication1 = new LeaveApplication();
        leaveApplication1.setReason("pqr");

        try {
             boolean status1 = leaveApplicationDao.updateRequest(leaveApplication1,"1");
            Assert.assertEquals(true,status1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAllTest() {

        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");

        try {
            boolean status = leaveApplicationDao.request(leaveApplication);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<LeaveApplication> leaveApplicatios = leaveApplicationDao.getAll();
            Assert.assertNotNull(leaveApplicatios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkStatus()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");

        try {
            boolean status = leaveApplicationDao.request(leaveApplication);
            Assert.assertEquals(true,status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            LeaveApplication leaveApplication1 = leaveApplicationDao.checkStatus("1");
            Assert.assertNotNull(leaveApplication1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByIDTest()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");

        try {
            boolean status = leaveApplicationDao.request(leaveApplication);
            Assert.assertEquals(true,status);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<LeaveApplication> leaveApplications = leaveApplicationDao.getById("AA");
            Assert.assertNotNull(leaveApplications);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkRequestTest() throws IOException// TODO: remaining
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
       // leaveApplication.setStatus();

        boolean status = leaveApplicationDao.request(leaveApplication);
        Assert.assertEquals(true,status);

        LeaveApplication leaveApplication1 = new LeaveApplication();
        leaveApplication.setId("1");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");

        boolean status1 = leaveApplicationDao.request(leaveApplication1);
        Assert.assertEquals(true,status1);
    }

}
