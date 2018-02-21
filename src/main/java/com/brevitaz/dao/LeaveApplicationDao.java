package com.brevitaz.dao;

import com.brevitaz.model.LeaveApplication;

import java.io.IOException;
import java.util.List;

public interface LeaveApplicationDao
{
    public boolean request(LeaveApplication leaveApplication) throws IOException;
    public List<LeaveApplication> getAll() throws IOException;
    public boolean update(LeaveApplication leaveApplication,String id) throws IOException;
    public boolean delete(String id)throws IOException;
    public LeaveApplication getById(String id)throws IOException;
}
