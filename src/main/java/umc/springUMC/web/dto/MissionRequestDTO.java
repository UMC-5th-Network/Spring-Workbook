package umc.springUMC.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDTO {

        @NotNull
        Integer reward;
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate deadline;
        @NotBlank
        String missionSpec;
        @NotNull
        Long storeId;

    }
}
