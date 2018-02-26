package com.brevitaz.dao;

import com.brevitaz.model.LeaveApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface LeaveApplicationDao {
    public boolean request(LeaveApplication leaveApplication, String employeeId) throws IOException;

    public boolean cancelRequest(String employeeId, String leaveApplicationId) throws IOException;

    public boolean updateRequest(LeaveApplication leaveApplication, String employeeId, String leaveApplicationId) throws IOException;

    public LeaveApplication checkStatus(String employeeId, String leaveApplicationId) throws IOException;

    public List<LeaveApplication> getById(String employeeId) throws IOException;

    public List<LeaveApplication> checkRequest() throws IOException;

    public boolean approveRequest(LeaveApplication leaveApplication, String employeeId, String leaveApplicationId) throws IOException;

    public boolean declineRequest(LeaveApplication leaveApplication, String employeeId, String leaveApplicationId) throws IOException;

   /* public LeaveApplication getReport();
*/

    public List<LeaveApplication> getAll() throws IOException;
}





