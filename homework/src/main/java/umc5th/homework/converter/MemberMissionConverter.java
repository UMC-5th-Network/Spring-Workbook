package umc5th.homework.converter;

import umc5th.homework.domain.Member;
import umc5th.homework.domain.Mission;
import umc5th.homework.domain.enums.MissionStatus;
import umc5th.homework.domain.mapping.MemberMission;
import umc5th.homework.web.dto.MemberMissionDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission){
        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLEGING)
                .build();

        memberMission.setMission(mission);
        memberMission.setMember(member);

        return memberMission;
    }
}
