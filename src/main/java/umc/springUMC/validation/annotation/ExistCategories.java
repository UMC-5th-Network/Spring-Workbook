package umc.springUMC.validation.annotation;

import umc.springUMC.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented // 사용자 정의 어노테이션을 의미
@Constraint(validatedBy = CategoriesExistValidator.class) // validation 지정 -> CategoriesExistValidator class를 통해 @ExistCategories가 붙은 대상을 검증
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) // 어노테이션의 적용 범위 설정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 생명 주기 지정. RUNTIME -> 실행 동안에만 유효
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
