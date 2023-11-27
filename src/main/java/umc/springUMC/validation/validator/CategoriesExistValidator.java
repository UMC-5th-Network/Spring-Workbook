package umc.springUMC.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.springUMC.apiPayload.code.status.ErrorStatus;
import umc.springUMC.repository.FoodCategoryRepository;
import umc.springUMC.validation.annotation.ExistCategories;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> { // @ExistCategories에 대한 로직을 담을 것이고, 검증 대상이 List<Long>이다.

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }  // ConstraintValidator -> isValid method 반환 값을 확인, false이면 ConstraintViloationException 발생

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        // List<Long> 값을 가진 카테고리가 모두 DB에 있는 지 판단, 없으면 false.

        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
