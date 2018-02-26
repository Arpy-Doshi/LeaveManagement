package com.brevitaz.controller;

import com.brevitaz.dao.LeavePolicyDao;
import com.brevitaz.dao.LeavePolicyRuleDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeavePolicy;
import com.brevitaz.model.LeavePolicyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/leave-policy-rules")
public class LeavePolicyRuleController {

    @Autowired
    LeavePolicyRuleDao leavePolicyRuleDao;

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public boolean create(@RequestBody LeavePolicyRule leavePolicyRule) throws IOException {
        return leavePolicyRuleDao.create(leavePolicyRule);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public boolean update(@RequestBody LeavePolicyRule leavePolicyRule,@PathVariable String id) throws IOException {
        return leavePolicyRuleDao.update(leavePolicyRule,id);
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id) throws IOException {
        return leavePolicyRuleDao.delete(id);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public LeavePolicyRule getById(@PathVariable String id) throws IOException {
        return leavePolicyRuleDao.getById(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<LeavePolicyRule> getAll() throws IOException {
        return leavePolicyRuleDao.getAll();
    }
}
