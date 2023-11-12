package umc5th.homework.domain;


import jakarta.persistence.*;
import lombok.*;
import umc5th.homework.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();
}
