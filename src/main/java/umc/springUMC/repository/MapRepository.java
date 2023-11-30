package umc.springUMC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springUMC.domain.Map;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Map, Long> {
    Optional<Map> findById(String name);
}
