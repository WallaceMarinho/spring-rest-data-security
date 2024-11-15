package br.edu.fatecsjc.lgnspringapi.controller;

import br.edu.fatecsjc.lgnspringapi.dto.MarathonDTO;
import br.edu.fatecsjc.lgnspringapi.service.MarathonService;
import br.edu.fatecsjc.lgnspringapi.converter.MarathonConverter;
import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marathons")
public class MarathonResource {

    @Autowired
    private MarathonService marathonService;

    @Autowired
    private MarathonConverter marathonConverter;

    @GetMapping
    public ResponseEntity<List<MarathonDTO>> getAllMarathons() {
        List<Marathon> marathons = marathonService.findAll();
        List<MarathonDTO> marathonDTOs = marathons.stream()
                .map(marathonConverter::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(marathonDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MarathonDTO> createMarathon(@RequestBody MarathonDTO marathonDTO) {
        Marathon marathon = marathonConverter.toEntity(marathonDTO);
        Marathon createdMarathon = marathonService.save(marathon);
        MarathonDTO createdMarathonDTO = marathonConverter.toDTO(createdMarathon);
        return new ResponseEntity<>(createdMarathonDTO, HttpStatus.CREATED);
    }
}
