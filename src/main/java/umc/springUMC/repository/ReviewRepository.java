package umc.springUMC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.springUMC.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
