package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="MemberPrefer")
@Table(name="member_prefer")
public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category",referencedColumnName = "id")
    private FoodCategory foodCategory;
}
