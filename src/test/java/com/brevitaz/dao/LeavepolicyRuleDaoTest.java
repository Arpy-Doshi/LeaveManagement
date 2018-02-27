package com.brevitaz.dao;

import com.brevitaz.model.LeavePolicyRule;
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
public class LeavepolicyRuleDaoTest {
    @Autowired
    LeavePolicyRuleDao leavePolicyRuleDao;
/*
    @Test
    public void createTest() {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("1");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("fcgtyuijklmnjbhvg");

        try {
            boolean status = leavePolicyRuleDao.create(leavePolicyRule);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllTest() {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("2");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("bfhdj");

        try {
            boolean status = leavePolicyRuleDao.create(leavePolicyRule);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<LeavePolicyRule> leavePolicyRules = leavePolicyRuleDao.getAll();
            Assert.assertNotNull(leavePolicyRules);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTest() {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("3");
        leavePolicyRule.setName("GHI");
        leavePolicyRule.setDescription("bbnjdnf");

        try {
            boolean status = leavePolicyRuleDao.create(leavePolicyRule);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            leavePolicyRule.setName("dmnfm");
            boolean status1 = leavePolicyRuleDao.update(leavePolicyRule,"3");
            Assert.assertEquals(true,status1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteTest() {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("4");
        leavePolicyRule.setName("Abc");
        leavePolicyRule.setDescription("kjdfd");

        try {
            boolean status = leavePolicyRuleDao.create(leavePolicyRule);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            boolean status1 = leavePolicyRuleDao.delete("4");
            Assert.assertEquals(true,status1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getByIdTest() {
        LeavePolicyRule leavePolicyRule = new LeavePolicyRule();
        leavePolicyRule.setId("4");
        leavePolicyRule.setName("Mno");
        leavePolicyRule.setDescription("bhjdfjl");

        try {
            boolean status = leavePolicyRuleDao.create(leavePolicyRule);
            Assert.assertEquals(true, status);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            LeavePolicyRule leavePolicyRule1  = leavePolicyRuleDao.getById("4");
            Assert.assertNotNull(leavePolicyRule1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    }