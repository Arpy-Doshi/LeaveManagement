package com.brevitaz.controller;

import com.brevitaz.dao.LeavePolicyDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeavePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/leave/policies")
public class LeavePolicyController {

    @Autowired
    LeavePolicyDao leavePolicyDao;

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public boolean create(@RequestBody LeavePolicy leavePolicy) throws IOException {
        return leavePolicyDao.create(leavePolicy);
    }

    @RequestMapping(value = "/{lpid}" , method = RequestMethod.PUT)
    public boolean update(@RequestBody LeavePolicy leavePolicy/*,@PathVariable String eid*/,@PathVariable String lpid) throws IOException {
        return leavePolicyDao.update(leavePolicy,lpid);
    }
    @RequestMapping(value = "/{lpid}" , method = RequestMethod.DELETE)
    public boolean delete(/*@PathVariable String eid,*/@PathVariable String lpid) throws IOException {
        return leavePolicyDao.delete(lpid);
    }

    @RequestMapping(value = "/{lpid}" , method = RequestMethod.GET)
    public LeavePolicy getById(@PathVariable String lpid) throws IOException {
        return leavePolicyDao.getById(lpid);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<LeavePolicy> getAll() throws IOException {
        return leavePolicyDao.getAll();
    }





}
