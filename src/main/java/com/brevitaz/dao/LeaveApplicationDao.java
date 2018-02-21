package com.brevitaz.dao;

import com.brevitaz.model.LeaveApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public interface LeaveApplicationDao {
    public boolean request(LeaveApplication leaveApplication, String eid) throws IOException;

    public boolean cancelRequest(String eid, String lid) throws IOException;

    public boolean updateRequest(LeaveApplication leaveApplication, String eid, String lid) throws IOException;

    public LeaveApplication checkStatus(String eid, String lid);

    public double checkBalance(String eid);

    public List<LeaveApplication> getById(String eid);

    public List<LeaveApplication> checkRequest();

    public boolean approveRequest(LeaveApplication leaveApplication, String eid, String lid);

    public boolean declineRequest(LeaveApplication leaveApplication, String eid, String lid);

   /* public LeaveApplication getReport();
*/
    public List<LeaveApplication> getAll() throws IOException;
}





