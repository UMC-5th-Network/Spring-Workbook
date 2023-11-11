package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Store")
@Table(name="store")
public class Store {

    @Id
    private long id;

    private String name;

    private String address;

    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id",referencedColumnName = "id")
    private Region region;


}
