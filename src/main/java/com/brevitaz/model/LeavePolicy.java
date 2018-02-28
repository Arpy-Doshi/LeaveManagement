package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class LeavePolicy
{
    private String id;
    private List<LeavePolicyRule> leavePolicyRules;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LeavePolicyRule> getLeavePolicyRules() {
        return leavePolicyRules;
    }

    public void setLeavePolicyRules(List<LeavePolicyRule> leavePolicyRules) {
        this.leavePolicyRules = leavePolicyRules;
    }

    @Override
    public String toString() {
        return "LeavePolicy{" +
                "id='" + id + '\'' +
                ", leavePolicyRules=" + leavePolicyRules +
                '}';
    }




}
