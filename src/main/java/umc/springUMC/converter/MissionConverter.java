package umc.springUMC.converter;

import umc.springUMC.domain.Mission;
import umc.springUMC.domain.Store;
import umc.springUMC.web.dto.MissionRequestDTO;
import umc.springUMC.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Mission toMission(MissionRequestDTO.AddMissionDTO request, Store store) {
        Mission newMission = Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();

        newMission.setStore(store);

        return newMission;
    }
}
