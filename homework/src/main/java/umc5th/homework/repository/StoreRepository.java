package umc5th.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.homework.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
