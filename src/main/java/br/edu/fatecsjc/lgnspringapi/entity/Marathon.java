package br.edu.fatecsjc.lgnspringapi.entity;
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

    @ManyToMany(mappedBy = "marathons")
    private List<Member> members;
}
