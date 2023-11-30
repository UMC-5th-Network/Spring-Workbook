package umc.springUMC.domain.mapping;

import lombok.*;
import umc.springUMC.domain.FoodCategory;
import umc.springUMC.domain.Member;

import javax.persistence.*;

// Member, FoodCategory와의 연관관계 주인

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFavor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodCategory foodCategory;

    public void setMember(Member member) {
        if(this.member != null)
            member.getMemberFavorList().remove(this);
        this.member = member;
        member.getMemberFavorList().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
