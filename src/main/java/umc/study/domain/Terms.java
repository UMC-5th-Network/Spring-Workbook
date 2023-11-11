package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Terms")
@Table(name="terms")
public class Terms {
    @Id
    private long id;

    private String title;

    private String body;

    private boolean optional;
}
