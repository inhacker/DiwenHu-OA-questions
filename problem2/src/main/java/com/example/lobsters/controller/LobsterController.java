package com.example.lobsters.controller;

import com.example.lobsters.exception.ResourceNotFoundException;
import com.example.lobsters.model.Lobster;
import com.example.lobsters.repository.LobsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class LobsterController {

    @Autowired
    LobsterRepository lobsterRepository;

    // Get All lobsters
    @GetMapping("/lobsters")
    public List<Lobster> getAllLobsters(){
        return lobsterRepository.findAll();
    }

    // Create a new Lobster
    @PostMapping("/lobsters")
    public Lobster createLobster(@Valid @RequestBody Lobster lobster){
        return lobsterRepository.save(lobster);
    }

    // Get a Single Lobster
    @GetMapping("/lobsters/{id}")
    public Lobster getLobsterById(@PathVariable(value = "id") Long lobsterId){
        return lobsterRepository.findById(lobsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Lobster", "id", lobsterId));
    }

    // Update a Lobster
    @PutMapping("/lobsters/{id}")
    public Lobster updateLobster(@PathVariable(value = "id") Long lobsterId,
                              @Valid @RequestBody Lobster lobsterDetails){
        Lobster lobster = lobsterRepository.findById(lobsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Lobster", "id", lobsterId));

        lobster.setName(lobsterDetails.getName());
        lobster.setKind(lobsterDetails.getKind());
        Lobster updateLobster = lobsterRepository.save(lobster);
        return updateLobster;
    }

    // Delete a Lobster
    @DeleteMapping("/lobsters/{id}")
    public ResponseEntity<?> deleteLobster(@PathVariable(value = "id") Long lobsterId){
        Lobster lobster = lobsterRepository.findById(lobsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Lobster", "id", lobsterId));
        lobsterRepository.delete(lobster);
        return ResponseEntity.ok().build();
    }

}