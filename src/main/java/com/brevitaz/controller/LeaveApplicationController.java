package com.brevitaz.controller;

import com.brevitaz.dao.LeaveApplicationDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeaveApplication;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/leave-applications")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationDao leaveApplicationDao;

    @RequestMapping(method = RequestMethod.POST)//do count type of leave in service
    public boolean request(@RequestBody LeaveApplication leaveApplication)  {
        return leaveApplicationDao.request(leaveApplication);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public boolean cancelRequest(@PathVariable String id)  {
        return leaveApplicationDao.cancelRequest(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean updateRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String id) {
        return leaveApplicationDao.updateRequest(leaveApplication,id);
    }



    @RequestMapping(value = "/leave-status/{id}" , method = RequestMethod.GET)
    public LeaveApplication checkStatus(@PathVariable String id) {
        return leaveApplicationDao.checkStatus(id);
    }

    @RequestMapping(value = "/remaining-leaves/{employeeId}" , method = RequestMethod.GET)//remaining
    public double checkBalance(@PathVariable String employeeId)
    {
        return 0;
    }

    @RequestMapping(value = "/{employeeId}" , method = RequestMethod.GET) // personal record.
    public List<LeaveApplication> getByEmployeeId( @PathVariable String employeeId)  {
        return leaveApplicationDao.getByEmployeeId(employeeId);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET) // for single leave.
    public List<LeaveApplication> getById( @PathVariable String id)  {
        return leaveApplicationDao.getById(id);
    }

    @RequestMapping(value = "/check-requests" , method = RequestMethod.GET)
    public List<LeaveApplication> checkRequest()  {
        return leaveApplicationDao.checkRequest();
    }

    @RequestMapping(value = "/approve-request/{id}" , method = RequestMethod.PUT)//status changes in service & request should be POST or PUT?
    public boolean approveRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String id) {
        return leaveApplicationDao.approveRequest(leaveApplication,id);
    }

    @RequestMapping(value = "/decline-request/{id}" , method = RequestMethod.DELETE)//status changes in service
    public boolean declineRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String id) {
        return leaveApplicationDao.declineRequest(leaveApplication,id);
    }

    // we will get this list from service using getAll method.
    @RequestMapping(value = "/get-by-date/{fromDate}/{toDate}" , method = RequestMethod.GET)
    public List<LeaveApplication> getByDate(@PathVariable Date fromDate,@PathVariable Date toDate) {
        return leaveApplicationDao.getAll();
    }

    @RequestMapping(value = "" , method = RequestMethod.GET) // all record.
    public List<LeaveApplication> getAll()  {
        return leaveApplicationDao.getAll();
    }




    //**************** what should i pass in below two methods ?
   /*
   @RequestMapping(value = "/get-report" , method = RequestMethod.GET)//2 things in service 1 is emp wise i.e. getById & 2 is date wise i.e.From Date To Date
    public LeaveApplication getReport()
    {
        //return leaveApplicationDao.getReport();
    }

*/





}
