package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaves")
public class EmployeeController {

    @RequestMapping(value = "/request" , method = RequestMethod.POST)
    public void requestLeave(@RequestBody Employee employee)
    {
        System.out.println("request is sent.");
    }

    @RequestMapping(value = "/cancelRequest" , method = RequestMethod.POST)
    public void cancelRequest(@RequestBody Employee employee)
    {
        System.out.println("cancelRequest is sent.");
    }

    @RequestMapping(value = "/checkStatus" , method = RequestMethod.POST)
    public void checkStatus(@RequestBody Employee employee)
    {
        System.out.println("leave status is checked.");
    }

    @RequestMapping(value = "/checkBalance" , method = RequestMethod.POST)
    public void checkBalance(@RequestBody Employee employee)
    {
        System.out.println("balance is checked.");
    }

    @RequestMapping(value = "/viewMyRecord" , method = RequestMethod.POST)
    public void viewMyRecord(@RequestBody Employee employee)
    {
        System.out.println("record is viewed.");
    }

    @RequestMapping(value = "/checkRequest" , method = RequestMethod.POST)
    public void checkRequest(@RequestBody Employee employee)
    {
        System.out.println("request is checked.");
    }
    @RequestMapping(value = "/approveRequest" , method = RequestMethod.POST)
    public void approveRequest(@RequestBody Employee employee)
    {
        System.out.println("request is approved.");
    }
    @RequestMapping(value = "/generateRecord" , method = RequestMethod.POST)
    public void generateRecord(@RequestBody Employee employee)
    {
        System.out.println("record is generated.");
    }

    @RequestMapping(value = "/viewRecord" , method = RequestMethod.POST)
    public void viewRecord(@RequestBody Employee employee)
    {
        System.out.println("record is viewed.");
    }
    @RequestMapping(value = "/createPolicy" , method = RequestMethod.POST)
    public void createPolicy(@RequestBody Employee employee)
    {
        System.out.println("policy is created.");
    }

    @RequestMapping(value = "/updatePolicy" , method = RequestMethod.POST)
    public void updatePolicy(@RequestBody Employee employee)
    {
        System.out.println("policy is updated.");
    }
    @RequestMapping(value = "/deletePolicy" , method = RequestMethod.POST)
    public void deletePolicy(@RequestBody Employee employee)
    {
        System.out.println("policy is deleted.");
    }

    @RequestMapping(value = "/viewPolicy" , method = RequestMethod.POST)
    public void viewPolicy(@RequestBody Employee employee)
    {
        System.out.println("policy is viewed.");
    }

}
