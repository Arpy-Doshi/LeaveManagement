package com.brevitaz.model;

import java.util.Date;

public class LeaveApplicaion
{

    private String reason;
    private Date fromDate;
    private Date toDate;
    private enum Type
    {
        PLANNED_LEAVE,UNPLANNED_LEAVE,LEAVE_WITHOUT_PAY;
    }
    private enum Status
    {
        APPLIED,ACCEPTED,DECLINED;
    }
    private enum Time
    {
        FIRSTHALF,SECONDHALF,FULLDAY;
    }




}
