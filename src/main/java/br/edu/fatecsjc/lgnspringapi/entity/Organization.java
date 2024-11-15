package br.edu.fatecsjc.lgnspringapi.entity;
import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
@Table(name = "organizations")
@Data  // Lombok já gera os métodos necessários
public class Organization {
    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "organizationidgen", sequenceName = "organization_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationidgen")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String institution;
    private String country;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Group> groups;
}

