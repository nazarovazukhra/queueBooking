package model;

import java.sql.Date;
import java.sql.Time;

public class TimeLine {
    private Integer id;
    private Time startTime;
    private Time endTime;
    private Boolean status;
    private Date date;
    private Integer doctor_id;

    public TimeLine() {
    }

    public TimeLine(Integer id, Time startTime, Time endTime, Boolean status, Date date, Integer doctor_id) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.date = date;
        this.doctor_id = doctor_id;
    }

    public TimeLine(Integer id, Time startTime, Time endTime, Boolean status, Date date) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.date = date;
    }

    public TimeLine(Time startTime, Time endTime, Boolean status, Date date) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.date = date;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }
}
