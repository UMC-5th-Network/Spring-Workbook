package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="ReviewImage")
@Table(name="review_image")
public class ReviewImage extends BaseEntity {
    @Id
    private long id;

    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id",referencedColumnName = "id")
    private Review review;
}
