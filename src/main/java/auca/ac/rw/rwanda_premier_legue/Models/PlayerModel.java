package auca.ac.rw.rwanda_premier_legue.Models;

import java.util.UUID;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Player")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "position")
    private String position;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "jersey")
    private String jerseyNumber;

 // Many-to-One relationship with TeamModel
 @ManyToOne
 @JoinColumn(name = "team_id", nullable = false) 
 @JsonBackReference 
 private TeamModel team;

 // Constructors, getters, and setters

 public PlayerModel() {
 }

 public PlayerModel(String firstName, String lastName, String dateOfBirth, String position, String nationality,
                    String jerseyNumber, TeamModel team) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.dateOfBirth = dateOfBirth;
     this.position = position;
     this.nationality = nationality;
     this.jerseyNumber = jerseyNumber;
     this.team = team;
 }

 // Getters and setters for all fields, including the team field

 public UUID getId() {
     return id;
 }

 public void setId(UUID id) {
     this.id = id;
 }

 public String getFirstName() {
     return firstName;
 }
 public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getDateOfBirth() {
    return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
}

public String getPosition() {
    return position;
}

public void setPosition(String position) {
    this.position = position;
}

public String getNationality() {
    return nationality;
}

public void setNationality(String nationality) {
    this.nationality = nationality;
}

public String getJerseyNumber() {
    return jerseyNumber;
}

public void setJerseyNumber(String jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
}

public TeamModel getTeam() {
    return team;
}

public void setTeam(TeamModel team) {
    this.team = team;
}
}

