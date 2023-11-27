package umc5th.homework.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc5th.homework.domain.common.BaseEntity;
import umc5th.homework.domain.enums.Gender;
import umc5th.homework.domain.enums.MemberStatus;
import umc5th.homework.domain.enums.SocilaType;
import umc5th.homework.domain.mapping.MemberAgree;
import umc5th.homework.domain.mapping.MemberMission;
import umc5th.homework.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "VARCHAR(10)")
    @Column(nullable = false, length = 10)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocilaType socilaType;

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    @Column(nullable = false, length = 15)
    @ColumnDefault("'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

//    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
