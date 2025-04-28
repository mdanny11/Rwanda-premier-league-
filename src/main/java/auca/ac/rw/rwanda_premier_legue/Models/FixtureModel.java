package auca.ac.rw.rwanda_premier_legue.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Add to MatchModel class
@ManyToOne
@JoinColumn(name = "fixture_id")
@JsonBackReference
private FixtureModel fixture;

@Entity
@Table(name = "fixtures")
public class FixtureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Integer matchDay;  // Round number (e.g., Matchday 1)

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private String season;

    @OneToMany(mappedBy = "fixture", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MatchModel> matches;

    // Constructors, Getters, Setters
    public FixtureModel() {}

    public FixtureModel(Integer matchDay, LocalDate startDate, LocalDate endDate, 
                      String season, List<MatchModel> matches) {
        this.matchDay = matchDay;
        this.startDate = startDate;
        this.endDate = endDate;
        this.season = season;
        this.matches = matches;
    }

    // Getters and Setters for all fields
    // ... (omitted for brevity, include all standard getters/setters)
}