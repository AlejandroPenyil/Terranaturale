package TFG.Terranaturale.Repository;

import TFG.Terranaturale.Model.Imagene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageneRepository extends JpaRepository<Imagene, Integer> {
}

