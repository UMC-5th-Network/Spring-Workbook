package umc.springUMC.converter;

import org.springframework.data.domain.Page;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Mission;
import umc.springUMC.domain.enums.Gender;
import umc.springUMC.domain.mapping.MemberMission;
import umc.springUMC.web.dto.MemberRequestDTO;
import umc.springUMC.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .password(request.getPassword())
                .age(request.getAge())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberFavorList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission memberMission){
        Mission mission = memberMission.getMission();
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MemberMission> missionList) {
        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
