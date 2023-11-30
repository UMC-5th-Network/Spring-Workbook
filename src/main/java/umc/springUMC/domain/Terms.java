package umc.springUMC.domain;

import lombok.*;
import umc.springUMC.domain.common.BaseEntity;
import umc.springUMC.domain.mapping.MemberTerms;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberTerms> memberTermsList = new ArrayList<>();

}
