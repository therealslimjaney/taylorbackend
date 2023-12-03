package com.example.demo;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

public interface UserRecordRepository extends DatastoreRepository<UserRecord, Long> {

    Optional<UserRecord> findByUserGoogleId(String userGoogleId);

    void deleteById(Long id);

}