package umc5th.homework.converter;

import umc5th.homework.domain.Member;
import umc5th.homework.domain.enums.Gender;
import umc5th.homework.web.dto.MemberRequestDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

// 컨버터를 사용하는 이유는 서비스가 비즈니스 로직에 좀더 집중하기 위헤


public class MemberConverter {
    public static MemberRequestDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberRequestDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
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
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())    // 양방향 매핑일 경우 리스트 초기화 해줘야 함다!!
                .build();
    }
}
