package auca.ac.rw.rwanda_premier_legue.Models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "standings")
public class StandingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamModel team;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private Integer played;

    @Column(nullable = false)
    private Integer won;

    @Column(nullable = false)
    private Integer drawn;

    @Column(nullable = false)
    private Integer lost;

    @Column(nullable = false)
    private Integer goalsFor;

    @Column(nullable = false)
    private Integer goalsAgainst;

    @Column(nullable = false)
    private Integer goalDifference;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private String season;

    public StandingModel() {
    }

    public StandingModel(TeamModel team, Integer position, Integer played, Integer won, 
                        Integer drawn, Integer lost, Integer goalsFor, Integer goalsAgainst, 
                        Integer points, String season) {
        this.team = team;
        this.position = position;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalsFor - goalsAgainst;
        this.points = points;
        this.season = season;
    }

    // Getters and Setters for all fields
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getDrawn() {
        return drawn;
    }

    public void setDrawn(Integer drawn) {
        this.drawn = drawn;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(Integer goalsFor) {
        this.goalsFor = goalsFor;
        this.updateGoalDifference();
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
        this.updateGoalDifference();
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    private void updateGoalDifference() {
        this.goalDifference = this.goalsFor - this.goalsAgainst;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}