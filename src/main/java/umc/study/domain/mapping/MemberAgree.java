package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Terms;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="MemberAgree")
@Table(name="member_agree")
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="terms_id",referencedColumnName = "id")
    private Terms terms;

}
