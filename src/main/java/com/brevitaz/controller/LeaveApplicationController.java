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
@RequestMapping("/leaves")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationDao leaveApplicationDao;

    @RequestMapping(value = "/{employee-id}" , method = RequestMethod.POST)//do count type of leave in service
    public boolean request(@RequestBody LeaveApplication leaveApplication, @PathVariable String employeeId) throws IOException {
        return leaveApplicationDao.request(leaveApplication,employeeId);
    }

    @RequestMapping(value = "/{employee-id}/{leave-application-id}" , method = RequestMethod.DELETE)
    public boolean cancelRequest(@PathVariable String employeeId , @PathVariable String leaveApplicationId) throws IOException {
        return leaveApplicationDao.cancelRequest(employeeId,leaveApplicationId);
    }

    @RequestMapping(value = "/{employee-id}/{leave-application-id}", method = RequestMethod.PUT)
    public boolean updateRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String employeeId , @PathVariable String leaveApplicationId) throws IOException {
        return leaveApplicationDao.updateRequest(leaveApplication,employeeId,leaveApplicationId);
    }



    @RequestMapping(value = "/{employee-id}/leave-status/{leave-application-id}" , method = RequestMethod.GET)
    public LeaveApplication checkStatus(@PathVariable String employeeId,@PathVariable String leaveApplicationId) throws IOException {
        return leaveApplicationDao.checkStatus(employeeId,leaveApplicationId);
    }

    @RequestMapping(value = "/remaining-leaves/{employee-id}" , method = RequestMethod.GET)//remaining
    public double checkBalance(@PathVariable String employeeId)
    {
        return 0;
    }

    @RequestMapping(value = "/{employee-id}" , method = RequestMethod.GET) // personal record.
    public List<LeaveApplication> getById( @PathVariable String employeeId) throws IOException {
        return leaveApplicationDao.getById(employeeId);
    }

    @RequestMapping(value = "/check-request" , method = RequestMethod.GET)
    public List<LeaveApplication> checkRequest() throws IOException {
        return leaveApplicationDao.checkRequest();
    }

    @RequestMapping(value = "{employee-id}/approve-request/{leave-application-id}" , method = RequestMethod.POST)//status changes in service
    public boolean approveRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String employeeId,@PathVariable String leaveApplicationId) throws IOException {
        return leaveApplicationDao.approveRequest(leaveApplication,employeeId,leaveApplicationId);
    }

    @RequestMapping(value = "{employee-id}/decline-request/{leave-application-id}" , method = RequestMethod.POST)//status changes in service
    public boolean declineRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String employeeId,@PathVariable String leaveApplicationId) throws IOException {
        return leaveApplicationDao.declineRequest(leaveApplication,employeeId,leaveApplicationId);
    }

    // we will get this list from service using getAll method.
    @RequestMapping(value = "/get-by-date/{fromDate}/{toDate}" , method = RequestMethod.GET)
    public List<LeaveApplication> getByDate(@PathVariable Date fromDate,@PathVariable Date toDate) throws IOException {
        return leaveApplicationDao.getAll();
    }

    @RequestMapping(value = "" , method = RequestMethod.GET) // all record.
    public List<LeaveApplication> getAll() throws IOException {
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
