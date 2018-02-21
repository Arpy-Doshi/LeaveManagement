package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import com.brevitaz.model.LeaveApplication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/leaves")
public class LeaveApplicationController {

    @RequestMapping(value = "/{eid}" , method = RequestMethod.POST)
    public boolean request(@RequestBody LeaveApplication leaveApplication, @PathVariable String eid)
    {
        return true;
    }

    @RequestMapping(value = "/{eid}/{lid}" , method = RequestMethod.DELETE)
    public void cancelRequest(@RequestBody LeaveApplication leaveApplication , @PathVariable String eid , @PathVariable String lid)
    {
        System.out.println("cancelRequest is sent.");
    }

    @RequestMapping(value = "/{eid}/{lid}" , method = RequestMethod.GET)
    public void checkStatus(@RequestBody LeaveApplication leaveApplication,@PathVariable String eid,@PathVariable String lid)
    {
        System.out.println("leave status is checked.");
    }

    @RequestMapping(value = "/remaining-leaves/{id}" , method = RequestMethod.GET)
    public void checkBalance(@PathVariable String id)
    {
        System.out.println("balance is checked.");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET) // personal record.
    public void getById( @PathVariable String id)
    {
        System.out.println("record is viewed.");
    }


//**************** what should i pass in below two methods ?
    @RequestMapping(value = "/check-request" , method = RequestMethod.GET)
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
    public void getAll()
    {
        System.out.println("record is viewed.");
    }


}
