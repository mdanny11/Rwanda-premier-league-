package auca.ac.rw.rwanda_premier_legue.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.rwanda_premier_legue.Models.TeamModel;
import auca.ac.rw.rwanda_premier_legue.Services.TeamServices;

@RestController
@RequestMapping("/teams")
public class TeamController {
   
     @Autowired
    private TeamServices teamServices;

       // Create a new player
    @PostMapping("/CreateTeam")
    public ResponseEntity<TeamModel> createTeam(@RequestBody TeamModel team) {
        TeamModel savedTeam = teamServices.saveTeam(team);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    // Get all teams
    @GetMapping("/GetAllTeams")
    public ResponseEntity<List<TeamModel>> getAllTeams() {
        List<TeamModel> teams = teamServices.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    // Get team by ID
    @GetMapping("/GetTeamById/{id}")
    public ResponseEntity<TeamModel> getTeamById(@PathVariable UUID id) {
        TeamModel team = teamServices.findTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

   @DeleteMapping("/DeleteTeam/{id}")
@ResponseStatus(HttpStatus.CREATED)
public void deleteTeam(@PathVariable UUID id) {
    teamServices.deleteTeam(id);
}
}
