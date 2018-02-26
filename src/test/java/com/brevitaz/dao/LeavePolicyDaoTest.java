package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import com.brevitaz.model.LeavePolicy;
import com.brevitaz.model.LeavePolicyRule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LeavePolicyDaoTest {
    @Autowired
    LeavePolicyDao leavePolicyDao;

    @Test
    public void createTest() {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("1");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("fcgtyuijklmnjbhvg");

        List<LeavePolicyRule> leavePolicyRules = new ArrayList<>();
        leavePolicyRules.add(leavePolicyRule);

        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setLeavePolicyRules(leavePolicyRules);

        try {
            boolean status = leavePolicyDao.create(leavePolicy);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllTest()
    {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("2");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("fcgtyuijklmnjbhvg");

        List<LeavePolicyRule> leavePolicyRules = new ArrayList<>();
        leavePolicyRules.add(leavePolicyRule);

        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("2");
        leavePolicy.setLeavePolicyRules(leavePolicyRules);

        try {
            boolean status = leavePolicyDao.create(leavePolicy);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<LeavePolicy> leavePolicies = leavePolicyDao.getAll();
            Assert.assertNotNull(leavePolicies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTest()
    {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("4");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("fcgtyuijklmnjbhvg");

        List<LeavePolicyRule> leavePolicyRules = new ArrayList<>();
        leavePolicyRules.add(leavePolicyRule);

        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("3");
        leavePolicy.setLeavePolicyRules(leavePolicyRules);

        try {
            boolean status = leavePolicyDao.create(leavePolicy);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LeavePolicyRule leavePolicyRule1 = new LeavePolicyRule();
        leavePolicyRule1.setId("3");

        List<LeavePolicyRule> leavePolicyRules1 = new ArrayList<>();
        leavePolicyRules1.add(leavePolicyRule1);

        leavePolicy.setLeavePolicyRules(leavePolicyRules1);

        try {
            boolean status1 = leavePolicyDao.update(leavePolicy,"3");
            Assert.assertEquals(true,status1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTest()
    {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("4");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("fcgtyuijklmnjbhvg");

        List<LeavePolicyRule> leavePolicyRules = new ArrayList<>();
        leavePolicyRules.add(leavePolicyRule);

        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("1");
        leavePolicy.setLeavePolicyRules(leavePolicyRules);

        try {
            boolean status = leavePolicyDao.create(leavePolicy);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            boolean status1 = leavePolicyDao.delete("4");
            Assert.assertEquals(true,status1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getByIdTest()
    {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("4");
        leavePolicyRule.setName("Mno");
        leavePolicyRule.setDescription("fcgtyuijklmnjbhvg");

        List<LeavePolicyRule> leavePolicyRules = new ArrayList<>();
        leavePolicyRules.add(leavePolicyRule);

        LeavePolicy leavePolicy = new LeavePolicy();
        leavePolicy.setId("4");
        leavePolicy.setLeavePolicyRules(leavePolicyRules);

        try {
            boolean status = leavePolicyDao.create(leavePolicy);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            LeavePolicy leavePolicy1 = leavePolicyDao.getById("4");
            Assert.assertNotNull(leavePolicy1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
