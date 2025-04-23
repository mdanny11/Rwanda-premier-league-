package auca.ac.rw.rwanda_premier_legue.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.rwanda_premier_legue.Models.TeamModel;
import auca.ac.rw.rwanda_premier_legue.Repository.TeamRepository;

@Service
public class TeamServices {
  
    @Autowired
    private TeamRepository teamRepository;

    public TeamModel saveTeam(TeamModel team) {
        return teamRepository.save(team);
    }

    public List<TeamModel> findAllTeams() {
        return teamRepository.findAll();
    }

    public TeamModel findTeamById(UUID id) {
        return teamRepository.findById(id)
                .orElseThrow();

    }

    public boolean deleteTeam(UUID id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true; 
        }
        return false; 
    }

    
}

