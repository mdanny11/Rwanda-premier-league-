package auca.ac.rw.rwanda_premier_legue.Services;

import org.springframework.stereotype.Service;
import auca.ac.rw.rwanda_premier_legue.Models.FixtureModel;
import auca.ac.rw.rwanda_premier_legue.Repository.FixtureRepository;

@Service
public class FixtureServices {

    @Autowired
    private FixtureRepository fixtureRepository;

    @Autowired
    private MatchRepository matchRepository;

    public FixtureModel createFixture(FixtureModel fixture) {
        return fixtureRepository.save(fixture);
    }

    public FixtureModel generateFullSeasonFixtures(List<TeamModel> teams, String season) {
        // Implementation for round-robin scheduling
        // Returns complete fixture list for the season
    }
}