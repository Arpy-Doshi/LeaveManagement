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
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        boolean status = leaveApplicationDao.request(leaveApplication);
        Assert.assertEquals(true,status);

        leaveApplicationDao.cancelRequest("11");
    }

    @Test
    public void cancelRequestTest()
    {  LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        boolean status = leaveApplicationDao.cancelRequest("11");
        Assert.assertEquals(true,status);
        leaveApplicationDao.cancelRequest("11");

    }

     @Test
    public void updateRequestTest()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        LeaveApplication leaveApplication1 = new LeaveApplication();
        leaveApplication1.setEmployeeId("22");

        boolean status = leaveApplicationDao.updateRequest(leaveApplication1,"11");
        Assert.assertEquals(true,status);

        leaveApplicationDao.cancelRequest("11");

    }

    @Test
    public void getAllTest() {

        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        List<LeaveApplication> leaveApplications = leaveApplicationDao.getAll();
        int size = leaveApplications.size();
        leaveApplicationDao.cancelRequest("11");
    }

    /*@Test
    public void checkStatus()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        boolean status = leaveApplicationDao.request(leaveApplication);
        Assert.assertEquals(true,status);

        leaveApplicationDao.cancelRequest("11");
    }

    @Test
    public void getByIDTest()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        boolean status = leaveApplicationDao.request(leaveApplication);
        Assert.assertEquals(true,status);

        leaveApplicationDao.cancelRequest("11");
    }


    @Test
    public void checkRequestTest() throws IOException// TODO: remaining
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplicationDao.request(leaveApplication);

        boolean status = leaveApplicationDao.request(leaveApplication);
        Assert.assertEquals(true,status);

        leaveApplicationDao.cancelRequest("11");
    }
*/
}
