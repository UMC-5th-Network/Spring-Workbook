package umc5th.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.homework.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
