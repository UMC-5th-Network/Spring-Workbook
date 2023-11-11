package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="ReviewImage")
@Table(name="review_image")
public class ReviewImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id",referencedColumnName = "id")
    private Review review;
}
