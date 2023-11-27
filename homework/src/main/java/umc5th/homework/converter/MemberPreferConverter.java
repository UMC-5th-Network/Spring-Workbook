package umc5th.homework.converter;

import umc5th.homework.domain.FoodCategory;
import umc5th.homework.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

//양방향 연관 관계 설정은 converter 보다는 service에서 하는 것이 좋다
//단뱡향은 컨버터에서 설정해도 괜찮다
public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
