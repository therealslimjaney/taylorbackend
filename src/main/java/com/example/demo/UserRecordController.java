package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Controller class handling HTTP requests related to user records.
 */
@RestController
public class UserRecordController {

    private final UserRecordRepository userRecordRepository;

    /**
     * Constructor for the UserRecordController.
     *
     * @param userRecordRepository The repository for user records.
     */
    @Autowired
    public UserRecordController(UserRecordRepository userRecordRepository) {
        this.userRecordRepository = userRecordRepository;
    }

    /**
     * Updates the user's nickname based on the Google ID.
     *
     * @param userGoogleId The Google ID of the user.
     * @param userHandle   The new user handle or nickname.
     */
    @PostMapping("/updateUserNickname")
    @CrossOrigin(origins = "*")
    public void updateUserNickname(@RequestParam String userGoogleId, @RequestParam String userHandle) {
        userRecordRepository.findByUserGoogleId(userGoogleId).ifPresent(userRecord -> {
            userRecord.setUserHandle(userHandle);
            userRecordRepository.save(userRecord);
        });
    }

    /**
     * Retrieves the user's nickname based on the Google ID.
     *
     * @param userGoogleId The Google ID of the user.
     * @return ResponseEntity containing the user's nickname or not found.
     */
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

    /**
     * Saves a new user record.
     *
     * @param userRecord The user record to be saved.
     */
    @PostMapping("/saveUserRecord")
    @CrossOrigin(origins = "*")
    public void saveUserRecord(@RequestBody UserRecord userRecord) {
        this.userRecordRepository.save(userRecord);
    }

    /**
     * Retrieves a user record based on the Google ID.
     *
     * @param userGoogleId The Google ID of the user.
     * @return Optional containing the user record, or empty if not found.
     */
    @GetMapping("/findByUserGoogleId")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Optional<UserRecord> findByUserGoogleId(@RequestParam String userGoogleId) {
        return userRecordRepository.findByUserGoogleId(userGoogleId);
    }
}
