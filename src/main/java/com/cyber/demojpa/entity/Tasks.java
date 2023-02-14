package com.cyber.demojpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    //    @Column(name = "user_id")
//    private  int userId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;


    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;
//    @Column(name = "job_id")
//    private int jobId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
//    @Column(name = "status_id")
//    private int statusID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
