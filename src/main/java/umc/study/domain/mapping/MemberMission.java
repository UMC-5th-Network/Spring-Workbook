package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="MemberMission")
@Table(name="member_mission")
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", referencedColumnName = "id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memebr_id", referencedColumnName = "id")
    private Member member;
}

