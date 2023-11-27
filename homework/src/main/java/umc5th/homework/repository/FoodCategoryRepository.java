package umc5th.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc5th.homework.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
