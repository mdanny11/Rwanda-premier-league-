package auca.ac.rw.rwanda_premier_legue.Controllers;

import org.springframework.web.bind.annotation.*;
import auca.ac.rw.rwanda_premier_legue.Models.FixtureModel;

@RestController
@RequestMapping("/fixtures")
public class FixtureController {

    @Autowired
    private FixtureServices fixtureServices;

    @PostMapping
    public ResponseEntity<FixtureModel> createFixture(@RequestBody FixtureModel fixture) {
        return new ResponseEntity<>(fixtureServices.createFixture(fixture), HttpStatus.CREATED);
    }

    @GetMapping("/season/{season}")
    public ResponseEntity<List<FixtureModel>> getSeasonFixtures(@PathVariable String season) {
        return ResponseEntity.ok(fixtureServices.getFixturesBySeason(season));
    }
}