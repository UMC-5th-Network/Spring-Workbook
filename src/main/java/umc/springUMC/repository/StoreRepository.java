package umc.springUMC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springUMC.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
