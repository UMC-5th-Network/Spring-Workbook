package umc5th.homework.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionDTO {

    @Getter
    public static class AddMemberMissionDTO {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
