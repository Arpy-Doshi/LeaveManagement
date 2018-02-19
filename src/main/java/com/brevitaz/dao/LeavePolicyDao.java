package com.brevitaz.dao;

import com.brevitaz.model.LeavePolicy;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public interface LeavePolicyDao
{
    public boolean create(LeavePolicy leavePolicy) throws IOException;
    public boolean update(LeavePolicy leavePolicy,String lpid) throws IOException;
    public boolean delete( String lpid) throws IOException;
    public LeavePolicy getById(String lpid) throws IOException;
    public List<LeavePolicy> getAll() throws IOException;

}
