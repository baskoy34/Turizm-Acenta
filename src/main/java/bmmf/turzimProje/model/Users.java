package bmmf.turzimProje.model;

import bmmf.turzimProje.model.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Set<AcentaUser> acentaUserSet = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Admins> admins = new HashSet<>();
}
