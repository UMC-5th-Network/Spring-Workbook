package umc5th.homework.converter;

import org.springframework.data.domain.Page;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.Store;
import umc5th.homework.web.dto.MissionDTO;
import umc5th.homework.web.dto.StoreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt())
                .updatedAt(mission.getUpdatedAt())
                .deadline(mission.getDeadline())
                .build();
    }

    public static StoreDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<StoreDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream().map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .reviewList(missionPreViewDTOList)
                .build();
    }
}
