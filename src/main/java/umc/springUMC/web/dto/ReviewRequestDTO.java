package umc.springUMC.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO {

        @NotBlank
        String title;
        @NotNull
        String body;
        @NotNull
        Float score;
        @NotNull
        Long memberId;
        @NotNull
        Long storeId;
        List<Long> reviewImg;
    }
}
