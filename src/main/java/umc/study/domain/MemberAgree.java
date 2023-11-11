package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="MemberAgree")
@Table(name="member_agree")
public class MemberAgree {

    @Id
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="terms_id",referencedColumnName = "id")
    private Terms terms;

}
