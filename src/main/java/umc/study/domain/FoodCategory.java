package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.study.domain.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Member")
@Table(name="member")
public class FoodCategory extends BaseEntity {
    @Id
    private long id;

    private String name;
}
