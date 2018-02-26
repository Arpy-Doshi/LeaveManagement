package com.brevitaz.controller;

import com.brevitaz.dao.LeavePolicyDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeavePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/leave-policies")
public class LeavePolicyController {

    @Autowired
    LeavePolicyDao leavePolicyDao;

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public boolean create(@RequestBody LeavePolicy leavePolicy) throws IOException {
        return leavePolicyDao.create(leavePolicy);
    }

    @RequestMapping(value = "/{leave-policy-id}" , method = RequestMethod.PUT)
    public boolean update(@RequestBody LeavePolicy leavePolicy,@PathVariable String leavePolicyId) throws IOException {
        return leavePolicyDao.update(leavePolicy,leavePolicyId);
    }
    @RequestMapping(value = "/{leave-policy-id}" , method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String leavePolicyId) throws IOException {
        return leavePolicyDao.delete(leavePolicyId);
    }

    @RequestMapping(value = "/{leave-policy-id}" , method = RequestMethod.GET)
    public LeavePolicy getById(@PathVariable String leavePolicyId) throws IOException {
        return leavePolicyDao.getById(leavePolicyId);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<LeavePolicy> getAll() throws IOException {
        return leavePolicyDao.getAll();
    }





}
