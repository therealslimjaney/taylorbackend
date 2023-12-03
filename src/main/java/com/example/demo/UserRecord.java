package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

/**
 * Entity class representing user records stored in the database.
 */
@Entity(name = "user_records")
public class UserRecord {

    @Id
    Long id;

    private String userGoogleId;
    private String userHandle;

    /**
     * Constructs a new UserRecord with the given user Google ID and user handle.
     *
     * @param userGoogleId The Google ID of the user.
     * @param userHandle   The handle or username chosen by the user.
     */
    public UserRecord(String userGoogleId, String userHandle) {
        this.userGoogleId = userGoogleId;
        this.userHandle = userHandle;
    }

    /**
     * Retrieves the Google ID associated with the user.
     *
     * @return The Google ID of the user.
     */
    public String getUserGoogleId() {
        return this.userGoogleId;
    }

    /**
     * Sets the Google ID for the user.
     *
     * @param googleId The Google ID to set.
     */
    public void setUserGoogleId(String googleId) {
        this.userGoogleId = googleId;
    }

    /**
     * Retrieves the user handle (username) chosen by the user.
     *
     * @return The user's chosen handle.
     */
    public String getUserHandle() {
        return this.userHandle;
    }

    /**
     * Sets the user handle (username) for the user.
     *
     * @param userHandle The handle to set.
     */
    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    /**
     * Retrieves the unique identifier for the UserRecord.
     *
     * @return The unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the UserRecord.
     *
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Generates a string representation of the UserRecord.
     *
     * @return A string representation of the UserRecord.
     */
    @Override
    public String toString() {
        return "UserRecord{" +
                "id=" + id +
                ", userGoogleId='" + userGoogleId + '\'' +
                ", userHandle='" + userHandle + '\'' +
                '}';
    }
}
