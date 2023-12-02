package umc.springUMC.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.springUMC.apiPayload.ApiResponse;
import umc.springUMC.converter.MemberMissionConverter;
import umc.springUMC.converter.MissionConverter;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.mapping.MemberMission;
import umc.springUMC.service.MissionService.MissionCommandService;
import umc.springUMC.web.dto.MemberMissionRequestDTO;
import umc.springUMC.web.dto.MemberMissionResponseDTO;
import umc.springUMC.web.dto.MissionRequestDTO;
import umc.springUMC.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {

        Mission mission = missionCommandService.addMission(request);
        MissionResponseDTO.AddMissionResultDTO resultDTO = MissionConverter.toAddMissionResultDTO(mission);
        return ApiResponse.onSuccess(resultDTO);
    }

    @PostMapping("/challenging")
    public ApiResponse<MemberMissionResponseDTO.AddMMResultDTO> addMM(@RequestBody @Valid MemberMissionRequestDTO.AddMMDTO request) {
        MemberMission memberMission = missionCommandService.challenging(request);
        MemberMissionResponseDTO.AddMMResultDTO resultDTO = MemberMissionConverter.toMMResultDTO(memberMission);
        return ApiResponse.onSuccess(resultDTO);
    }
}
