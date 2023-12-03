package com.example.demo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Comparator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpSession;

@RestController
public class UserRecordController {
    private final UserRecordRepository userRecordRepository;

    @Autowired
    public UserRecordController(UserRecordRepository userRecordRepository) {
        this.userRecordRepository = userRecordRepository;
    }

    @PostMapping("/updateUserNickname")
    @CrossOrigin(origins = "*")
    public void updateUserNickname(@RequestParam String userGoogleId, @RequestParam String userHandle) {
        userRecordRepository.findByUserGoogleId(userGoogleId).ifPresent(userRecord -> {
            userRecord.setUserHandle(userHandle);
            userRecordRepository.save(userRecord);
        });
    }



    @GetMapping("/getUserNickname")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> getUserNickname(@RequestParam String userGoogleId) {
        Optional<UserRecord> optionalUserRecord = userRecordRepository.findByUserGoogleId(userGoogleId);

        if (optionalUserRecord.isPresent()) {
            String nickname = optionalUserRecord.get().getUserHandle();
            return ResponseEntity.ok(nickname);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveUserRecord")
    @CrossOrigin(origins = "*")
    public void saveUserRecord(@RequestBody UserRecord userRecord) {
        this.userRecordRepository.save(userRecord);
    }

    @GetMapping("/findByUserGoogleId")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Optional<UserRecord> findByUserGoogleId(@RequestParam String userGoogleId) {
        return userRecordRepository.findByUserGoogleId(userGoogleId);
    }
}