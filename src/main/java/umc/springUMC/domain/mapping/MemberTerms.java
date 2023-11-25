package umc.springUMC.domain.mapping;

import lombok.*;
import umc.springUMC.domain.Member;
import umc.springUMC.domain.Terms;

import javax.persistence.*;

// Member, Terms와의 연관관계 주인

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;

}
