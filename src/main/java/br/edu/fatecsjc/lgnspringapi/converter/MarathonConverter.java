package br.edu.fatecsjc.lgnspringapi.converter;

import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import br.edu.fatecsjc.lgnspringapi.dto.MarathonDTO;
import org.springframework.stereotype.Component;

@Component
public class MarathonConverter {

    public MarathonDTO toDTO(Marathon marathon) {
        return MarathonDTO.builder()
                .id(marathon.getId())
                .identifier(marathon.getIdentifier())
                .weight(marathon.getWeight())
                .score(marathon.getScore())
                .build();
    }

    public Marathon toEntity(MarathonDTO marathonDTO) {
        return Marathon.builder()
                .id(marathonDTO.getId())
                .identifier(marathonDTO.getIdentifier())
                .weight(marathonDTO.getWeight())
                .score(marathonDTO.getScore())
                .build();
    }
}
