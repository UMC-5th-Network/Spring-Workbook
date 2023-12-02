package umc.springUMC.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.springUMC.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService{

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public boolean isExists(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
