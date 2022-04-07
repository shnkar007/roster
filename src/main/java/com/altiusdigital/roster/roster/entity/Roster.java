package com.altiusdigital.roster.roster.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="roster")
public class Roster {
    @Id
    @GeneratedValue
    @Column(name="roster_id")
    private int rosterId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="date")
    private String date;
    @Column(name="sector1")
    private String sector1;
    @Column(name="sector1_start_time")
    private String sector1StartTime;
    @Column(name="sector1_end_time")
    private String sector1EndTime;
    @Column(name="sector2")
    private String sector2;
    @Column(name="sector2_start_time")
    private String sector2StartTime;
    @Column(name="sector2_end_time")
    private String sector2EndTime;
    @Column(name="sector3")
    private String sector3;
    @Column(name="sector3_start_time")
    private String sector3StartTime;
    @Column(name="sector3_end_time")
    private String sector3EndTime;

    public int getRosterId() {
        return rosterId;
    }

    public void setRosterId(int rosterId) {
        this.rosterId = rosterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSector1() {
        return sector1;
    }

    public void setSector1(String sector1) {
        this.sector1 = sector1;
    }

    public String getSector1StartTime() {
        return sector1StartTime;
    }

    public void setSector1StartTime(String sector1StartTime) {
        this.sector1StartTime = sector1StartTime;
    }

    public String getSector1EndTime() {
        return sector1EndTime;
    }

    public void setSector1EndTime(String sector1EndTime) {
        this.sector1EndTime = sector1EndTime;
    }

    public String getSector2() {
        return sector2;
    }

    public void setSector2(String sector2) {
        this.sector2 = sector2;
    }

    public String getSector2StartTime() {
        return sector2StartTime;
    }

    public void setSector2StartTime(String sector2StartTime) {
        this.sector2StartTime = sector2StartTime;
    }

    public String getSector2EndTime() {
        return sector2EndTime;
    }

    public void setSector2EndTime(String sector2EndTime) {
        this.sector2EndTime = sector2EndTime;
    }

    public String getSector3() {
        return sector3;
    }

    public void setSector3(String sector3) {
        this.sector3 = sector3;
    }

    public String getSector3StartTime() {
        return sector3StartTime;
    }

    public void setSector3StartTime(String sector3StartTime) {
        this.sector3StartTime = sector3StartTime;
    }

    public String getSector3EndTime() {
        return sector3EndTime;
    }

    public void setSector3EndTime(String sector3EndTime) {
        this.sector3EndTime = sector3EndTime;
    }
}
