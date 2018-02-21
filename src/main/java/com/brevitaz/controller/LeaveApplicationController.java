package com.brevitaz.controller;

import com.brevitaz.dao.LeaveApplicationDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeaveApplication;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/leaves")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationDao leaveApplicationDao;

    LeaveApplication leaveApplication = null;
    List<LeaveApplication> leaveApplications = null;


    @RequestMapping(value = "/{eid}" , method = RequestMethod.POST)
    public boolean request(@RequestBody LeaveApplication leaveApplication, @PathVariable String eid) throws IOException {
        return leaveApplicationDao.request(leaveApplication,eid);
    }

    @RequestMapping(value = "/{eid}/{lid}" , method = RequestMethod.DELETE)
    public boolean cancelRequest(@PathVariable String eid , @PathVariable String lid) throws IOException {
        return leaveApplicationDao.cancelRequest(eid,lid);
    }

    @RequestMapping(value = "/{eid}/{lid}", method = RequestMethod.PUT)
    public boolean updateRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String eid , @PathVariable String lid) throws IOException {
        return leaveApplicationDao.updateRequest(leaveApplication,eid,lid);
    }



    @RequestMapping(value = "/{eid}/leave-status/{lid}" , method = RequestMethod.GET)
    public LeaveApplication checkStatus(@PathVariable String eid,@PathVariable String lid) throws IOException {
        return leaveApplicationDao.checkStatus(eid,lid);
    }

    @RequestMapping(value = "/remaining-leaves/{eid}" , method = RequestMethod.GET)
    public double checkBalance(@PathVariable String eid)
    {
        return 0;
    }

    @RequestMapping(value = "/{eid}" , method = RequestMethod.GET) // personal record.
    public LeaveApplication getById( @PathVariable String eid) throws IOException {
        return leaveApplicationDao.getById(eid);
    }

    @RequestMapping(value = "/check-request" , method = RequestMethod.GET)
    public List<LeaveApplication> checkRequest() throws IOException {
        return leaveApplicationDao.checkRequest();
    }

    @RequestMapping(value = "{eid}/approve-request/{lid}" , method = RequestMethod.POST)//status changes in service
    public boolean approveRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String eid,@PathVariable String lid) throws IOException {
        return leaveApplicationDao.approveRequest(leaveApplication,eid,lid);
    }

    @RequestMapping(value = "{eid}/decline-request/{lid}" , method = RequestMethod.POST)//status changes in service
    public boolean declineRequest(@RequestBody LeaveApplication leaveApplication,@PathVariable String eid,@PathVariable String lid) throws IOException {
        return leaveApplicationDao.declineRequest(leaveApplication,eid,lid);
    }

   /* @RequestMapping(value = "/get-report" , method = RequestMethod.GET)//2 things in service 1 is emp wise i.e. getById & 2 is date wise i.e.From Date To Date
    public LeaveApplication getReport()
    {
        return leaveApplicationDao.getReport();
    }*/

    @RequestMapping(value = "" , method = RequestMethod.GET) // all record.
    public List<LeaveApplication> getAll() throws IOException {
        return leaveApplicationDao.getAll();
    }




    //**************** what should i pass in below two methods ?
   /* @RequestMapping(value = "/{eid}" , method = RequestMethod.GET) // getByDate remaining.
    public List<LeaveApplication> getByDate( @PathVariable String eid)
    {
        return leaveApplications;
    }
*/





}
