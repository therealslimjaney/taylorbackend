package com.example.demo;

import com.example.demo.GameRecordRepository;
import com.example.demo.GameRecord;

import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpSession;

@RestController
public class GameRecordController {
    private final GameRecordRepository gameRecordRepository;

    @Autowired
    public GameRecordController(GameRecordRepository gameRecordRepository) {
        this.gameRecordRepository = gameRecordRepository;
    }

    @PostMapping("/saveGameRecord")
    @CrossOrigin(origins = "*")
    public void saveGameRecord(@RequestBody GameRecord gameRecord) {
        this.gameRecordRepository.save(gameRecord);
    }

    @DeleteMapping("/deleteGameRecord")
    @CrossOrigin(origins = "*")
    public void deleteGameRecord(@RequestParam Long id) {
        this.gameRecordRepository.deleteById(id);
    }

    @GetMapping("/findByGoogleId")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Page<GameRecord> findByGoogleId(@RequestParam String googleId, Pageable pageable) {
        return gameRecordRepository.findByGoogleId(googleId, pageable);
    }

    @GetMapping("/topOverallScores")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Page<GameRecord> getTopOverallScores(Pageable pageable) {
        // Retrieve paginated game records from the repository, sorted by score in
        // descending order
        return gameRecordRepository.findAllByOrderByScoreDesc(pageable);
    }
}