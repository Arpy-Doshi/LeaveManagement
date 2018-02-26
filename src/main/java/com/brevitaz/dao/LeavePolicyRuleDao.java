package com.brevitaz.dao;

import com.brevitaz.model.LeavePolicyRule;

import java.io.IOException;
import java.util.List;

public interface LeavePolicyRuleDao
{
    public boolean create(LeavePolicyRule leavePolicyRule) throws IOException;
    public boolean update(LeavePolicyRule leavePolicyRule,String id) throws IOException;
    public boolean delete( String id) throws IOException;
    public LeavePolicyRule getById(String id) throws IOException;
    public List<LeavePolicyRule> getAll() throws IOException;

}
