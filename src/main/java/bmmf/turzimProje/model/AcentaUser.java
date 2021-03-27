package bmmf.turzimProje.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "acentauser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcentaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserID", nullable = false)
    private Users user;
    private String acentaName;
}
