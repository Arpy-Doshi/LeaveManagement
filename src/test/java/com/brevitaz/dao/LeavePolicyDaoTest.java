package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import com.brevitaz.model.LeavePolicy;
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
public class LeavePolicyDaoTest {
/*
    @Autowired
    LeavePolicyDao leavePolicyDao;

    @Test
    public void createTest() throws IOException {
        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setName("leave");

        leavePolicy.setDescription("you have to request for leave before 15 days.");

        boolean status = leavePolicyDao.create(leavePolicy);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {

        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setName("leave");

        leavePolicy.setDescription("you have to request for leave before 15 days.");

        boolean status = leavePolicyDao.create(leavePolicy);
        Assert.assertEquals(true,status);

        List<LeavePolicy> leavePolicies = leavePolicyDao.getAll();
        Assert.assertNotNull(leavePolicies);

       *//* int size = leavePolicies.size();
        Assert.assertEquals(1,size);*//*
    }

    @Test
    public void get() throws IOException {
        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setName("leave");

        leavePolicy.setDescription("you have to request for leave before 15 days.");

        boolean status = leavePolicyDao.create(leavePolicy);
        Assert.assertEquals(true,status);

        LeavePolicy leavePolicy1 = leavePolicyDao.getById("1");
        Assert.assertNotNull(leavePolicy1);
    }

    @Test
    public void update() throws IOException {
        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setName("leave");

        leavePolicy.setDescription("you have to request for leave before 15 days.");

        boolean status = leavePolicyDao.create(leavePolicy);
        Assert.assertEquals(true,status);

        LeavePolicy leavePolicy1 = new LeavePolicy();
        leavePolicy.setDescription("you have to request for leave before 10 days.");
        boolean status1 = leavePolicyDao.update(leavePolicy1,"1");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void delete() throws IOException {
        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setName("leave");

        leavePolicy.setDescription("you have to request for leave before 15 days.");

        boolean status = leavePolicyDao.create(leavePolicy);
        Assert.assertEquals(true,status);

        boolean status1=leavePolicyDao.delete("1");
        Assert.assertEquals(true,status1);
    }*/
}
