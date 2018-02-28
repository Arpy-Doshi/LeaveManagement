package com.brevitaz.dao;

import com.brevitaz.model.LeaveApplication;
import com.brevitaz.model.Status;
import com.brevitaz.model.Type;
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
        leaveApplication.setStatus(Status.APPLIED);
        leaveApplication.setType(Type.PLANNED_LEAVE);
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

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<LeaveApplication> leaveApplications = leaveApplicationDao.getAll();
        int size = leaveApplications.size();
        Assert.assertEquals(1,size);

        leaveApplicationDao.cancelRequest("11");
    }

    @Test
    public void getByIdTest()
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setReason("xyz");
        leaveApplication.setStatus(Status.APPLIED);
        leaveApplicationDao.request(leaveApplication);

        LeaveApplication leaveApplication1 = leaveApplicationDao.getById("11");
        Assert.assertEquals(leaveApplication1.getStatus(),leaveApplication.getStatus());

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

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<LeaveApplication> leaveApplications = leaveApplicationDao.getById("AA");
        int size = leaveApplications.size();
        Assert.assertEquals(1,size);
        leaveApplicationDao.cancelRequest("11");
    }


    @Test
    public void checkRequestTest() throws IOException// TODO: remaining
    {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setId("11");
        leaveApplication.setEmployeeId("AA");
        leaveApplication.setType(Type.PLANNED_LEAVE);
        leaveApplication.setStatus(Status.APPLIED);
        leaveApplicationDao.request(leaveApplication);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<LeaveApplication> leaveApplications = leaveApplicationDao.checkRequest();
        int size = leaveApplications.size();
        Assert.assertEquals(1,size);

        leaveApplicationDao.cancelRequest("11");
    }

}
