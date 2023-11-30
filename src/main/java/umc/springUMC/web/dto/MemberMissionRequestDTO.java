package umc.springUMC.web.dto;

import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class AddMMDTO {
        Long memberId;
        Long missionId;
    }
}
