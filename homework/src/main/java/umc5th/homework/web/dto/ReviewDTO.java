package umc5th.homework.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewDTO {

    @Getter
    public static class AddRequestDTO{
        @NotNull
        String title;
        @NotNull
        String body;
        @NotNull
        Float score;
        @NotNull
        Long scoreId;
        @NotNull
        Long memberId;
    }
}
