package umc.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="Member")
@Table(name="member")
public class Member {

    @Id
    private long id;

    private String name;

    private String gender;

    private int age;

    private String address;

    private String spec_address;

    private String status;

    private LocalDateTime inactive_date;

    private String social_type;

    private String email;

    private int point;

}
