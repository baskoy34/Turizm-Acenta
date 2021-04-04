package bmmf.turzimProje.model;

import lombok.*;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acentauser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcentaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acenta_id_seq")
    @SequenceGenerator(name = "acenta_id_seq",
            sequenceName = "acenta_seq",
            allocationSize = 1)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID", nullable = false)
    private Users user;

    private String acentaName;

    @OneToMany(mappedBy = "acentaUser")
    private Set<Tour> tours = new HashSet<>();

    @OneToMany(mappedBy = "acentaUser")
    private Set<Staff> staffs = new HashSet<>();


}


