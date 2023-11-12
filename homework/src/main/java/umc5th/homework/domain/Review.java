package umc5th.homework.domain;

import jakarta.persistence.*;
import lombok.*;
import umc5th.homework.domain.common.BaseEntity;
import umc5th.homework.domain.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Float score;
}
