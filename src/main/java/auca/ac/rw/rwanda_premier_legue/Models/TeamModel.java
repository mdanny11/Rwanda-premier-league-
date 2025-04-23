package auca.ac.rw.rwanda_premier_legue.Models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class TeamModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "Names")
    private String name;

    @Column(name = "logo")
    private String logo;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "coach")
    private String coach;

    @Column(name = "foundedYear")
    private String foundedYear;
     
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference 
    private List<PlayerModel> players;

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("team-homeMatches")
    private List<MatchModel> homeMatches;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("team-awayMatches")
    private List<MatchModel> awayMatches;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("team-standing")
    private StandingModel standing;

    public TeamModel() {
    }

    public TeamModel(UUID id, String name, String logo, String stadium, String coach, 
                    String foundedYear, List<PlayerModel> players, 
                    List<MatchModel> homeMatches, List<MatchModel> awayMatches, 
                    StandingModel standing) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.stadium = stadium;
        this.coach = coach;
        this.foundedYear = foundedYear;
        this.players = players;
        this.homeMatches = homeMatches;
        this.awayMatches = awayMatches;
        this.standing = standing;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public List<PlayerModel> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerModel> players) {
        this.players = players;
    }

    public List<MatchModel> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(List<MatchModel> homeMatches) {
        this.homeMatches = homeMatches;
    }

    public List<MatchModel> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(List<MatchModel> awayMatches) {
        this.awayMatches = awayMatches;
    }

    public StandingModel getStanding() {
        return standing;
    }

    public void setStanding(StandingModel standing) {
        this.standing = standing;
    }

    // Helper methods
    public void addPlayer(PlayerModel player) {
        players.add(player);
        player.setTeam(this);
    }

    public void removePlayer(PlayerModel player) {
        players.remove(player);
        player.setTeam(null);
    }

    public void addHomeMatch(MatchModel match) {
        homeMatches.add(match);
        match.setHomeTeam(this);
    }

    public void addAwayMatch(MatchModel match) {
        awayMatches.add(match);
        match.setAwayTeam(this);
    }

    public void setStandingAndLink(StandingModel standing) {
        this.standing = standing;
        if (standing != null) {
            standing.setTeam(this);
        }
    }
}