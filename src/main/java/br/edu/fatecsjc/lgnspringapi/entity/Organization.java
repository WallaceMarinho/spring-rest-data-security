// Organization.java
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
@Table(name = "organizations")
public class Organization {
    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "organizationidgen", sequenceName = "organization_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationidgen")
    private Long id;

    private String name;
    private String address;
    private String institution;
    private String country;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Group> groups;
}
