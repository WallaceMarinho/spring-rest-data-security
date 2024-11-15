// Marathon.java
package br.edu.fatecsjc.lgnspringapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "marathon")
public class Marathon {
    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "marathonidgen", sequenceName = "marathon_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marathonidgen")
    private Long id;

    private String identifier;
    private Double weight;
    private Integer score;

    @ManyToMany(mappedBy = "marathon")
    private List<Member> members;
}
