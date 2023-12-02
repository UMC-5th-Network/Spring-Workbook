package umc.springUMC.web.dto;

import lombok.Getter;
import umc.springUMC.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {

        @NotBlank
        String name;
        @NotNull
        String password;
        @NotNull
        Integer age;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> favorCategory;
    }
}
