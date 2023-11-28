package umc5th.homework.domain;


import jakarta.persistence.*;
import lombok.*;
import umc5th.homework.domain.common.BaseEntity;
import umc5th.homework.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reward", nullable = false)
    private Integer reward;
    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;
    @Column(name = "missionSpec", nullable = false)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void setStore(Store store){
        this.store = store;
        store.getMissionList().add(this);
    }
}
