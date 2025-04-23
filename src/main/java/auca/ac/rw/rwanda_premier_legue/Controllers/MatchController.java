package auca.ac.rw.rwanda_premier_legue.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.rwanda_premier_legue.Models.MatchModel;
import auca.ac.rw.rwanda_premier_legue.Services.MatchServices;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchServices matchServices;

    @PostMapping("/create/{homeTeamId}/{awayTeamId}")
    public ResponseEntity<MatchModel> createMatch(
            @PathVariable UUID homeTeamId,
            @PathVariable UUID awayTeamId,
            @RequestBody MatchModel match) {
        
        MatchModel savedMatch = matchServices.createMatch(homeTeamId, awayTeamId, match);
        return new ResponseEntity<>(savedMatch, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchModel> getMatchById(@PathVariable UUID id) {
        MatchModel match = matchServices.findMatchById(id);
        return ResponseEntity.ok(match);
    }

    @GetMapping
    public ResponseEntity<List<MatchModel>> getAllMatches() {
        return ResponseEntity.ok(matchServices.findAllMatches());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable UUID id) {
        matchServices.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/scores")
    public ResponseEntity<MatchModel> updateMatchScores(
            @PathVariable UUID id,
            @RequestParam Integer homeScore,
            @RequestParam Integer awayScore) {
        
        MatchModel updatedMatch = matchServices.updateMatchScores(id, homeScore, awayScore);
        return ResponseEntity.ok(updatedMatch);
    }
}