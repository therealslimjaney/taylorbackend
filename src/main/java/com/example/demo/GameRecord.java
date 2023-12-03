package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

/**
 * Entity class representing game records.
 */
@Entity(name = "game_records")
public class GameRecord {

    @Id
    Long id;

    String googleId;

    int score;

    String date;

    /**
     * Constructor to initialize GameRecord object.
     *
     * @param googleId The Google ID of the player.
     * @param score    The score achieved in the game.
     * @param date     The date when the game record was created.
     */
    public GameRecord(String googleId, int score, String date) {
        this.googleId = googleId;
        this.score = score;
        this.date = date;
    }

    /**
     * Gets the ID of the game record.
     *
     * @return The ID of the game record.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets the ID of the game record.
     *
     * @param id The ID to set for the game record.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the Google ID of the player.
     *
     * @return The Google ID of the player.
     */
    public String getGoogleId() {
        return this.googleId;
    }

    /**
     * Sets the Google ID of the player.
     *
     * @param googleId The Google ID to set for the player.
     */
    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    /**
     * Gets the score achieved in the game.
     *
     * @return The score achieved in the game.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the score achieved in the game.
     *
     * @param score The score to set for the game.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the date when the game record was created.
     *
     * @return The date when the game record was created.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Sets the date when the game record was created.
     *
     * @param date The date to set for the game record.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Overrides the toString method to provide a string representation of the GameRecord object.
     *
     * @return A string representation of the GameRecord object.
     */
    @Override
    public String toString() {
        return "{" +
                "id:" + this.id +
                ", googleId:'" + this.googleId + '\'' +
                ", score:" + this.score +
                ", date:'" + this.date + '\'' +
                '}';
    }
}
