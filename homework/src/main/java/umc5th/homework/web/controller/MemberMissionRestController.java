package umc5th.homework.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc5th.homework.apiPayload.ApiResponse;
import umc5th.homework.converter.MemberMissionConverter;
import umc5th.homework.domain.enums.MissionStatus;
import umc5th.homework.domain.mapping.MemberMission;
import umc5th.homework.service.MemberSerice.MemberMissionService;
import umc5th.homework.web.dto.MemberMissionDTO;

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

    //challenging
    @GetMapping("/{memberId}/searchBychallenging")
    @Operation(summary = "내가 진행중인 미션 목록 API",description = "내가 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<MemberMissionDTO.MemberMissionPreViewListDTO> getMissionList(@PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissions = memberMissionService.searchMemberMission(memberId, MissionStatus.CHALLEGING, page);
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreViewListDTO(memberMissions));
    }


    @PostMapping("/{memberMissionId}/save_complete")
    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API",description = "진행중인 미션 진행 완료로 바꾸는 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberMissionId", description = "멤버 미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<Long> getMissionList(@PathVariable(name = "memberMissionId") Long memberMissionId){
        Long id = memberMissionService.saveComplete(memberMissionId);
        return ApiResponse.onSuccess(id);
    }
}
