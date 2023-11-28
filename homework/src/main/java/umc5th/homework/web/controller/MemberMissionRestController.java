package umc5th.homework.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.mapping.MemberMission;
import umc5th.homework.service.MemberMissionService;
import umc5th.homework.service.MissionService;
import umc5th.homework.web.dto.MemberMissionDTO;
import umc5th.homework.web.dto.MissionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member_mission")
public class MemberMissionRestController {
    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<Long> join(@RequestBody @Valid MemberMissionDTO.AddMemberMissionDTO dto){
        MemberMission memberMission = memberMissionService.addMemberMission(dto);
        return ApiResponse.onSuccess(memberMission.getId());
    }
}
