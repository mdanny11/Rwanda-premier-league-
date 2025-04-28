package auca.ac.rw.rwanda_premier_legue.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import auca.ac.rw.rwanda_premier_legue.Models.FixtureModel;
import java.util.List;

@Repository
public interface FixtureRepository extends JpaRepository<FixtureModel, UUID> {
    List<FixtureModel> findBySeason(String season);
    List<FixtureModel> findByMatchDayAndSeason(Integer matchDay, String season);
}