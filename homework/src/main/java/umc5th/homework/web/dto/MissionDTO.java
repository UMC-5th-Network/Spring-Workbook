package umc5th.homework.web.dto;

import lombok.Getter;

import java.time.LocalDate;

public class MissionDTO {

    @Getter
    public static class AddRequestDTO{
        Integer reward;
        LocalDate deadline;
        String missionSpec;
            Long storeId;
    }
}
