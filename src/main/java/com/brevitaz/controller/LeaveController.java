package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @RequestMapping(value = "/request" , method = RequestMethod.POST)
    public void request(@RequestBody Employee employee)
    {
        System.out.println("request is sent.");
    }

    @RequestMapping(value = "/cancel-request/{id}" , method = RequestMethod.DELETE)
    public void cancelRequest(@PathVariable String id)
    {
        System.out.println("cancelRequest is sent.");
    }

    @RequestMapping(value = "/check-status/{id}" , method = RequestMethod.GET)
    public void checkStatus(@PathVariable String id)
    {
        System.out.println("leave status is checked.");
    }

    @RequestMapping(value = "/check-balance/{id}" , method = RequestMethod.GET)
    public void checkBalance(@PathVariable String id)
    {
        System.out.println("balance is checked.");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET) // personal record.
    public void getByName( @PathVariable String id)
    {
        System.out.println("record is viewed.");
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
    public void getAll()
    {
        System.out.println("record is viewed.");
    }


}
