package com.example.demo;

import com.example.demo.GameRecordRepository;
import com.example.demo.GameRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpSession;

/**
 * Controller class for handling GameRecord-related operations.
 */
@RestController
public class GameRecordController {

    private final GameRecordRepository gameRecordRepository;

    /**
     * Constructor to initialize GameRecordController.
     *
     * @param gameRecordRepository The repository for GameRecord entities.
     */
    @Autowired
    public GameRecordController(GameRecordRepository gameRecordRepository) {
        this.gameRecordRepository = gameRecordRepository;
    }

    /**
     * Saves a game record to the database.
     *
     * @param gameRecord The GameRecord object to be saved.
     */
    @PostMapping("/saveGameRecord")
    @CrossOrigin(origins = "*")
    public void saveGameRecord(@RequestBody GameRecord gameRecord) {
        this.gameRecordRepository.save(gameRecord);
    }

    /**
     * Deletes a game record from the database by ID.
     *
     * @param id The ID of the GameRecord to be deleted.
     */
    @DeleteMapping("/deleteGameRecord")
    @CrossOrigin(origins = "*")
    public void deleteGameRecord(@RequestParam Long id) {
        this.gameRecordRepository.deleteById(id);
    }

    /**
     * Retrieves paginated game records associated with a Google ID.
     *
     * @param googleId The Google ID for which game records are retrieved.
     * @param pageable The pagination information.
     * @return A paginated list of GameRecord objects associated with the specified Google ID.
     */
    @GetMapping("/findByGoogleId")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Page<GameRecord> findByGoogleId(@RequestParam String googleId, Pageable pageable) {
        return gameRecordRepository.findByGoogleId(googleId, pageable);
    }

    /**
     * Retrieves the top overall scores from the database.
     *
     * @param pageable The pagination information.
     * @return A paginated list of GameRecord objects representing the top overall scores.
     */
    @GetMapping("/topOverallScores")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Page<GameRecord> getTopOverallScores(Pageable pageable) 
