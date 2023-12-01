package umc.springUMC.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springUMC.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean isExits(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
