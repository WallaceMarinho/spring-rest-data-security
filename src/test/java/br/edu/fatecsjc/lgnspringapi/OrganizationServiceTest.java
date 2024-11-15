@ExtendWith(MockitoExtension.class)
class OrganizationServiceTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @InjectMocks
    private OrganizationService organizationService;

    @Test
    void testSaveOrganization() {
        // Arrange
        Organization organization = Organization.builder()
                .id(1L)
                .name("Test Org")
                .institution("Test Institution")
                .country("Test Country")
                .address(new Address("123", "Test Street", "Neighborhood", "00000-000", "City", "State"))
                .build();

        Mockito.when(organizationRepository.save(Mockito.any(Organization.class))).thenReturn(organization);

        // Act
        Organization savedOrganization = organizationService.save(organization);

        // Assert
        Assertions.assertNotNull(savedOrganization);
        Assertions.assertEquals(1L, savedOrganization.getId());
        Assertions.assertEquals("Test Org", savedOrganization.getName());
    }

    @Test
    void testFindAllOrganizations() {
        // Arrange
        List<Organization> organizations = List.of(
                Organization.builder().id(1L).name("Org 1").build(),
                Organization.builder().id(2L).name("Org 2").build()
        );

        Mockito.when(organizationRepository.findAll()).thenReturn(organizations);

        // Act
        List<Organization> result = organizationService.findAll();

        // Assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Org 1", result.get(0).getName());
    }

    @Test
    void testDeleteOrganizationById() {
        // Arrange
        Long id = 1L;
        Mockito.doNothing().when(organizationRepository).deleteById(id);

        // Act
        organizationService.deleteById(id);

        // Assert
        Mockito.verify(organizationRepository, Mockito.times(1)).deleteById(id);
    }
}