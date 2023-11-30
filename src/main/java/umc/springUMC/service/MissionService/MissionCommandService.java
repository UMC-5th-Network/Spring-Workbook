package umc.springUMC.service.MissionService;

import umc.springUMC.domain.Mission;
import umc.springUMC.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO.AddMissionDTO request);
}
