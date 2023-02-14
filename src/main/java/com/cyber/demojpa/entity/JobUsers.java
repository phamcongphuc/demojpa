package com.cyber.demojpa.entity;

import javax.persistence.*;

@Entity(name = "sub_job")
//@IdClass(IdJobUsers.class)
public class JobUsers {

    @EmbeddedId
    IdJobUsers idJobUsers;
//    @Id
//    @Column(name="user_id")
//    private int userId;
//
//    @Id
//    @Column(name = "job_id")
//    private int jobId;
}
