package com.brevitaz.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

public class LeaveApplicaion
{

    private String reason;
    private Date fromDate;
    private Date toDate;
    private Type type;
    private Status status;
    private Time time;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LeaveApplicaion{" +
                "reason='" + reason + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", type=" + type +
                ", status=" + status +
                ", time=" + time +
                '}';
    }
}
