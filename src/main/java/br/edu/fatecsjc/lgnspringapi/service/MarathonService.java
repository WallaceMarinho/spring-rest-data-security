package br.edu.fatecsjc.lgnspringapi.service;

import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import br.edu.fatecsjc.lgnspringapi.repository.MarathonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarathonService {

    private final MarathonRepository marathonRepository;

    @Autowired
    public MarathonService(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    public Marathon createMarathon(Marathon marathon) {
        return marathonRepository.save(marathon);
    }

    public List<Marathon> getAllMarathons() {
        return marathonRepository.findAll();
    }

    public Optional<Marathon> getMarathonById(Long id) {
        return marathonRepository.findById(id);
    }

    public Marathon updateMarathon(Long id, Marathon marathon) {
        if (!marathonRepository.existsById(id)) {
            throw new RuntimeException("Marathon not found");
        }
        marathon.setId(id);
        return marathonRepository.save(marathon);
    }

    public void deleteMarathon(Long id) {
        marathonRepository.deleteById(id);
    }
}
