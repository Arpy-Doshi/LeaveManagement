package com.brevitaz.dao;

import com.brevitaz.model.LeaveApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface LeaveApplicationDao {
    public boolean request(LeaveApplication leaveApplication);

    public boolean cancelRequest(String id);

    public boolean updateRequest(LeaveApplication leaveApplication, String id) ;

    public LeaveApplication getById( String id);

    public List<LeaveApplication> getByEmployeeId(String employeeId);

    public List<LeaveApplication> checkRequest() ;

    public boolean approveRequest(LeaveApplication leaveApplication,String id);

    public boolean declineRequest(LeaveApplication leaveApplication, String id);

   /* public LeaveApplication getReport();
*/

    public List<LeaveApplication> getAll();
}





