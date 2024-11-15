@Component
public class OrganizationConverter {
    public OrganizationDTO toDTO(Organization organization) {
        return new OrganizationDTO(
                organization.getId(),
                organization.getName(),
                organization.getInstitution(),
                organization.getCountry(),
                organization.getAddress()
        );
    }

    public Organization toEntity(OrganizationDTO organizationDTO) {
        return Organization.builder()
                .id(organizationDTO.getId())
                .name(organizationDTO.getName())
                .institution(organizationDTO.getInstitution())
                .country(organizationDTO.getCountry())
                .address(organizationDTO.getAddress())
                .build();
    }
}
