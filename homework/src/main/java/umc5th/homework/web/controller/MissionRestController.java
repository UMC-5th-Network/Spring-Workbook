package umc5th.homework.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.converter.MemberConverter;
import umc5th.homework.domain.Member;
import umc5th.homework.domain.Mission;
import umc5th.homework.service.MissionService;
import umc5th.homework.web.dto.MemberRequestDTO;
import umc5th.homework.web.dto.MissionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<Long> join(@RequestBody @Valid MissionDTO.AddRequestDTO request){
        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(mission.getId());
    }
}
