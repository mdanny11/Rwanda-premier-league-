package auca.ac.rw.rwanda_premier_legue.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "matches")
public class MatchModel {

    public enum MatchStatus {
        SCHEDULED, ONGOING, COMPLETED, POSTPONED, CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private TeamModel homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private TeamModel awayTeam;

    @Column(nullable = false)
    private LocalDateTime matchDateTime;

    @Column
    private String venue;

    @Column
    private Integer homeTeamScore;

    @Column
    private Integer awayTeamScore;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private Integer matchDay;

    @Column
    private String season;

    public MatchModel() {
    }

    public MatchModel(TeamModel homeTeam, TeamModel awayTeam, LocalDateTime matchDateTime, String venue, 
                     Integer homeTeamScore, Integer awayTeamScore, MatchStatus status, 
                     Integer matchDay, String season) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDateTime = matchDateTime;
        this.venue = venue;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.status = status;
        this.matchDay = matchDay;
        this.season = season;
    }

    // Getters and Setters for all fields
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TeamModel getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamModel homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamModel getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamModel awayTeam) {
        this.awayTeam = awayTeam;
    }

    public LocalDateTime getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(LocalDateTime matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}