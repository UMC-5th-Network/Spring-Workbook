package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Review")
@Table(name="review")
public class Review {
    @Id
    private long id;

    private String body;

    private float score;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="store_id",referencedColumnName = "id")
    private Store store;
}
