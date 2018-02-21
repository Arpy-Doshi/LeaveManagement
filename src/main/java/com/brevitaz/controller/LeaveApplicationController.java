package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import com.brevitaz.model.LeaveApplication;
import jdk.net.SocketFlow;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/leaves")
public class LeaveApplicationController {


    LeaveApplication leaveApplication = null;
    List<LeaveApplication> leaveApplications = null;


    @RequestMapping(value = "/{eid}" , method = RequestMethod.POST)
    public boolean request(@RequestBody LeaveApplication leaveApplication, @PathVariable String eid)
    {
        return true;
    }

    @RequestMapping(value = "/{eid}/{lid}" , method = RequestMethod.DELETE)
    public boolean cancelRequest(@PathVariable String eid , @PathVariable String lid)
    {
        return true;
    }

    @RequestMapping(value = "/{eid}/leave-status/{lid}" , method = RequestMethod.GET)
    public LeaveApplication checkStatus(@PathVariable String eid,@PathVariable String lid)
    {
        return leaveApplication;
    }

    @RequestMapping(value = "/remaining-leaves/{eid}" , method = RequestMethod.GET)
    public void checkBalance(@PathVariable String eid)
    {
        System.out.println("balance is checked.");
    }

    @RequestMapping(value = "/{eid}" , method = RequestMethod.GET) // personal record.
    public LeaveApplication getById( @PathVariable String eid)
    {
        return leaveApplication;
    }


    //**************** what should i pass in below two methods ?
    @RequestMapping(value = "/check-request/" , method = RequestMethod.GET)
    public void checkRequest()
    {
        System.out.println("request is checked.");
    }
    @RequestMapping(value = "/approve-request" , method = RequestMethod.POST)
    public void approveRequest(@RequestBody Employee employee)
    {
        System.out.println("request is approved.");
    }
    /*@RequestMapping(value = "/generate-record" , method = RequestMethod.POST)
    public void generateRecord(@RequestBody Employee employee)
    {
        System.out.println("record is generated.");
    }*/

    @RequestMapping(value = "" , method = RequestMethod.GET) // all record.
    public List<LeaveApplication> getAll()
    {
        return leaveApplications;
    }
}
