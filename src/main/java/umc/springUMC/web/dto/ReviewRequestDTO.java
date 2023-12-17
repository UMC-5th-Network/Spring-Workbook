package umc.springUMC.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class WriteReviewDTO {

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
