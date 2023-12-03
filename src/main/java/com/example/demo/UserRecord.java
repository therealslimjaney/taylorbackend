package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.google.cloud.spring.data.datastore.core.mapping.Entity;

import java.util.Date;

@Entity(name = "user_records")
public class UserRecord {


    @Id
    Long id;

    private String userGoogleId;
    private String userHandle;

    public UserRecord(String userGoogleId, String userHandle) {
        this.userGoogleId = userGoogleId;
        this.userHandle = userHandle;
    }

    public String getUserGoogleId() {
        return this.userGoogleId;
    }

    public void setUserGoogleId(String googleId) {
        this.userGoogleId = googleId;
    }

    public String getUserHandle() {
        return this.userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserRecord{" +
                "id=" + id +
                ", userGoogleId='" + userGoogleId + '\'' +
                ", userHandle='" + userHandle + '\'' +
                '}';
    }
}