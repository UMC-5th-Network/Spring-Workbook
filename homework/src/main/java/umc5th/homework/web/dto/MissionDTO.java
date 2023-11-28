package umc5th.homework.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionDTO {

    @Getter
    public static class AddRequestDTO{
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        String missionSpec;
        @NotNull
        Long storeId;
    }
}
