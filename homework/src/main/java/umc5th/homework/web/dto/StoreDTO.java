package umc5th.homework.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class StoreDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResponseDTO {
        Long storeId;
        LocalDateTime createdAt;
    }

    @Getter
    public static class AddDTO{
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @NotNull
        private Float score;
        @NotNull
        private String region;
    }
}
