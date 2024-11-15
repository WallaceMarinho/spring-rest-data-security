package br.edu.fatecsjc.lgnspringapi.controller;

import br.edu.fatecsjc.lgnspringapi.dto.OrganizationDTO;
import br.edu.fatecsjc.lgnspringapi.service.OrganizationService;
import br.edu.fatecsjc.lgnspringapi.converter.OrganizationConverter;
import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;
    private final OrganizationConverter organizationConverter;

    public OrganizationController(OrganizationService organizationService, OrganizationConverter organizationConverter) {
        this.organizationService = organizationService;
        this.organizationConverter = organizationConverter;
    }

    @GetMapping
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationService.findAll()
                .stream()
                .map(organizationConverter::toDTO)
                .toList();
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        Organization organization = organizationConverter.toEntity(organizationDTO);
        Organization savedOrganization = organizationService.save(organization);
        return ResponseEntity.ok(organizationConverter.toDTO(savedOrganization));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
        organizationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
