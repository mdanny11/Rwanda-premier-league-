package auca.ac.rw.rwanda_premier_legue.Controllers;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.rwanda_premier_legue.Models.PlayerModel;
import auca.ac.rw.rwanda_premier_legue.Services.PlayerServices;

@RestController
@RequestMapping("/players")
public class PlayerController {
    
    @Autowired
    private PlayerServices playerServices;

       // Create a new player
       @PostMapping("/createPlayer/{teamId}")
       public ResponseEntity<PlayerModel> createPlayer(
               @PathVariable UUID teamId,
               @RequestBody PlayerModel player) {
           
           PlayerModel savedPlayer = playerServices.createPlayer(teamId, player);
           return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
               }

     // Get team by ID
    @GetMapping("/GetPlayerById/{id}")
    public ResponseEntity<PlayerModel> getPlayerById(@PathVariable UUID id) {
        PlayerModel player = playerServices.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
   
    //     // Update player
    // @PutMapping("/{id}")
    // public ResponseEntity<PlayerModel> updatePlayer(
    //         @PathVariable Long id, 
    //         @RequestBody PlayerModel playerDetails) {
    //     PlayerModel updatedPlayer = playerServices.updatePlayer(id, playerDetails);
    //     return ResponseEntity.ok(updatedPlayer);
    // }

      // Delete player
    @DeleteMapping("/deletePlayer{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable UUID id) {
        playerServices.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}

