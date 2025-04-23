package auca.ac.rw.rwanda_premier_legue.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import auca.ac.rw.rwanda_premier_legue.Models.StandingModel;
import auca.ac.rw.rwanda_premier_legue.Models.TeamModel;
import auca.ac.rw.rwanda_premier_legue.Repository.StandingRepository;
import auca.ac.rw.rwanda_premier_legue.Repository.TeamRepository;

@Service
public class StandingServices {

    @Autowired
    private StandingRepository standingRepository;

    @Autowired
    private TeamRepository teamRepository;

    public StandingModel createStanding(UUID teamId, StandingModel standing) {
        TeamModel team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Team not found with id: " + teamId));

        standing.setTeam(team);
        return standingRepository.save(standing);
    }

    public StandingModel findStandingById(UUID id) {
        return standingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Standing not found with id: " + id));
    }

    public List<StandingModel> findAllStandings() {
        return standingRepository.findAll();
    }

    public void deleteStanding(UUID id) {
        StandingModel standing = findStandingById(id);
        standingRepository.delete(standing);
    }

    public StandingModel updateStanding(UUID id, StandingModel standingDetails) {
        StandingModel standing = findStandingById(id);
        
        standing.setPosition(standingDetails.getPosition());
        standing.setPlayed(standingDetails.getPlayed());
        standing.setWon(standingDetails.getWon());
        standing.setDrawn(standingDetails.getDrawn());
        standing.setLost(standingDetails.getLost());
        standing.setGoalsFor(standingDetails.getGoalsFor());
        standing.setGoalsAgainst(standingDetails.getGoalsAgainst());
        standing.setPoints(standingDetails.getPoints());
        standing.setSeason(standingDetails.getSeason());
        
        return standingRepository.save(standing);
    }
}