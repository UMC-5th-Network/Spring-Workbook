package umc.springUMC.converter;

import umc.springUMC.domain.FoodCategory;
import umc.springUMC.domain.mapping.MemberFavor;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFavorConverter {

    public static List<MemberFavor> toMemberFavorList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberFavor.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
