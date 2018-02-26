package com.brevitaz.dao;

import com.brevitaz.model.LeavePolicyRule;

import java.io.IOException;
import java.util.List;

public interface LeavePolicyRuleDao
{
    public boolean create(LeavePolicyRule leavePolicyRule) throws IOException;
    public boolean update(LeavePolicyRule leavePolicyRule,String leavePolicyRuleId) throws IOException;
    public boolean delete( String leavePolicyRuleId) throws IOException;
    public LeavePolicyRule getById(String leavePolicyRuleId) throws IOException;
    public List<LeavePolicyRule> getAll() throws IOException;

}
