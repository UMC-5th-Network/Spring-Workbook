package umc5th.homework.converter;

import umc5th.homework.domain.Mission;
import umc5th.homework.domain.Store;
import umc5th.homework.web.dto.MissionDTO;

import java.util.ArrayList;

public class MissionConverter {
    public static Mission toMission(MissionDTO.AddRequestDTO addRequestDTO, Store store){
        Mission mission = Mission.builder()
                .reward(addRequestDTO.getReward())
                .missionSpec(addRequestDTO.getMissionSpec())
                .deadline(addRequestDTO.getDeadline())
                .memberMissionList(new ArrayList<>())
                .build();

        mission.setStore(store);

        return mission;
    }
}
