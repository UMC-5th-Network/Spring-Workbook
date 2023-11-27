package umc5th.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc5th.homework.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService{
    private final FoodCategoryRepository foodCategoryRepository;

    public boolean isExists(Long id){
        return foodCategoryRepository.existsById(id);
    }
}
