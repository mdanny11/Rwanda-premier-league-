package auca.ac.rw.rwanda_premier_legue.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.rwanda_premier_legue.Models.StandingModel;
import auca.ac.rw.rwanda_premier_legue.Services.StandingServices;

@RestController
@RequestMapping("/standings")
public class StandingController {

    @Autowired
    private StandingServices standingServices;

    @PostMapping("/create/{teamId}")
    public ResponseEntity<StandingModel> createStanding(
            @PathVariable UUID teamId,
            @RequestBody StandingModel standing) {
        
        StandingModel savedStanding = standingServices.createStanding(teamId, standing);
        return new ResponseEntity<>(savedStanding, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandingModel> getStandingById(@PathVariable UUID id) {
        StandingModel standing = standingServices.findStandingById(id);
        return ResponseEntity.ok(standing);
    }

    @GetMapping
    public ResponseEntity<List<StandingModel>> getAllStandings() {
        return ResponseEntity.ok(standingServices.findAllStandings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStanding(@PathVariable UUID id) {
        standingServices.deleteStanding(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandingModel> updateStanding(
            @PathVariable UUID id,
            @RequestBody StandingModel standingDetails) {
        
        StandingModel updatedStanding = standingServices.updateStanding(id, standingDetails);
        return ResponseEntity.ok(updatedStanding);
    }
}