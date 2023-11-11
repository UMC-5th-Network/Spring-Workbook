package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.study.domain.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Mission")
@Table(name="mission")
public class Mission extends BaseEntity {

    @Id
    private long id;

    private int reward;

    private LocalDateTime deadline;

    private String mission_spec;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id", referencedColumnName = "id")
    private Store store;
    */
}
