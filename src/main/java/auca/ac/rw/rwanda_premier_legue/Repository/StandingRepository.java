package auca.ac.rw.rwanda_premier_legue.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import auca.ac.rw.rwanda_premier_legue.Models.StandingModel;

@Repository
public interface StandingRepository extends JpaRepository<StandingModel, UUID> {
}