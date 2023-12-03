package com.example.demo;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import java.util.Optional;

/**
 * Repository interface for managing user records in the Datastore.
 */
public interface UserRecordRepository extends DatastoreRepository<UserRecord, Long> {

    /**
     * Retrieves a user record based on the Google ID.
     *
     * @param userGoogleId The Google ID of the user.
     * @return Optional containing the user record, or empty if not found.
     */
    Optional<UserRecord> findByUserGoogleId(String userGoogleId);

    /**
     * Deletes a user record based on the ID.
     *
     * @param id The ID of the user record to be deleted.
     */
    void deleteById(Long id);
}
