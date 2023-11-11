package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.Store;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Mission")
@Table(name="mission")
public class Mission {

    @Id
    private long id;

    private int reward;

    private LocalDateTime deadline;

    private String mission_spec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stored_id", referencedColumnName = "id")
    private Store store;
}
