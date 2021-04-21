package model;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment {
    private Integer aptId;
    private Integer patientId;
    private Integer doctorId;
    private LocalDateTime createdAt;
    private List<TimeLine> appointmentTime;

    public Appointment() {
    }

    public Appointment(Integer patientId, Integer doctorId, LocalDateTime createdAt, List<TimeLine> appointmentTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdAt = createdAt;
        this.appointmentTime = appointmentTime;
    }

    public Appointment(Integer aptId, Integer patientId, Integer doctorId, LocalDateTime createdAt) {
        this.aptId = aptId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdAt = createdAt;
    }

    public Appointment(Integer aptId, Integer patientId, Integer doctorId, LocalDateTime createdAt, List<TimeLine> appointmentTime) {
        this.aptId = aptId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdAt = createdAt;
        this.appointmentTime = appointmentTime;
    }

    public Integer getAptId() {
        return aptId;
    }

    public void setAptId(Integer aptId) {
        this.aptId = aptId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<TimeLine> getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(List<TimeLine> appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
