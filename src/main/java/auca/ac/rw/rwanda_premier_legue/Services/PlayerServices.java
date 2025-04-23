package auca.ac.rw.rwanda_premier_legue.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import auca.ac.rw.rwanda_premier_legue.Models.PlayerModel;
import auca.ac.rw.rwanda_premier_legue.Models.TeamModel;
import auca.ac.rw.rwanda_premier_legue.Repository.PlayerRepository;
import auca.ac.rw.rwanda_premier_legue.Repository.TeamRepository;

@Service
public class PlayerServices {
  
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

public PlayerModel createPlayer(UUID teamId, PlayerModel player) {
    TeamModel team = teamRepository.findById(teamId)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Team not found with id: " + teamId));
    
    player.setTeam(team); 
    return playerRepository.save(player);
}

// findById
public PlayerModel findPlayerById(UUID id) {
    return playerRepository.findById(id)
            .orElseThrow();

}    
    // Get all players
    public List<PlayerModel> findAll() {
        return playerRepository.findAll();
    }
      // Delete player
      public void deletePlayer(UUID id) {
        PlayerModel player = findPlayerById(id); 
        playerRepository.delete(player);
    }

        // Update player
        // public PlayerModel updatePlayer(Long id, PlayerModel playerDetails) {
        //     PlayerModel player = findById(id); // Reuse our findById method
            
        //     // Update the fields you want to allow for updates
        //     player.setName(playerDetails.getName());
        //     player.setPosition(playerDetails.getPosition());
        //     player.setJerseyNumber(playerDetails.getJerseyNumber());
        //     // Add any other fields that should be updatable
            
        //     return playerRepository.save(player);
        // }
    
    
}
