package umc.springUMC.service.MissionService;

import umc.springUMC.domain.Mission;
import umc.springUMC.domain.mapping.MemberMission;
import umc.springUMC.web.dto.MemberMissionRequestDTO;
import umc.springUMC.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO.AddMissionDTO request); // mission 추가
    MemberMission challenging(MemberMissionRequestDTO.AddMMDTO request);
}
