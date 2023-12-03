package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;
import java.util.List;

public interface GameRecordRepository extends DatastoreRepository<GameRecord, Long> {


    Page<GameRecord> findAllByOrderByScoreDesc(Pageable pageable);

    Page<GameRecord> findByGoogleId(String googleId, Pageable pageable);
}