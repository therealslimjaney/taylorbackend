package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import java.util.List;

/**
 * Repository interface for accessing and managing GameRecord entities in the database.
 */
public interface GameRecordRepository extends DatastoreRepository<GameRecord, Long> {

    /**
     * Retrieves a paginated list of GameRecords sorted by score in descending order.
     *
     * @param pageable The pagination information.
     * @return A paginated list of GameRecord objects sorted by score in descending order.
     */
    Page<GameRecord> findAllByOrderByScoreDesc(Pageable pageable);

    /**
     * Retrieves a paginated list of GameRecords associated with a specific Google ID.
     *
     * @param googleId The Google ID for which game records are retrieved.
     * @param pageable The pagination information.
     * @return A paginated list of GameRecord objects associated with the specified Google ID.
     */
    Page<GameRecord> findByGoogleId(String googleId, Pageable pageable);
}
