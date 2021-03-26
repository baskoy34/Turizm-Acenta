package bmmf.turzimProje.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
