package TFG.Terranaturale.Repository;

import TFG.Terranaturale.Model.Solicitude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudeRepository extends JpaRepository<Solicitude, Integer> {
}
